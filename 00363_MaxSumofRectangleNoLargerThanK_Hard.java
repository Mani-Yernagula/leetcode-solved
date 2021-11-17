/*Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.
It is guaranteed that there will be a rectangle with a sum no larger than k.
  Example 1:
Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
Example 2:
Input: matrix = [[2,2,-1]], k = 3
Output: 3
  Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-105 <= k <= 105
  Follow up: What if the number of rows is much larger than the number of columns?*/
 
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] psum = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + matrix[i - 1][j - 1];
                System.out.print(psum[i][j]+", ");
            }
            System.out.println("");
        }
        int res = Integer.MIN_VALUE;
        
         for(int si = 0; si < m; si++){
            for(int sj = 0; sj < n; sj++){
                //si, sj
                for(int ei = si; ei < m; ei++){
                    for(int ej = sj; ej < n; ej++){
                        //ei, ej
                        //find sum of rectangle si,sj ends with ei,ej
                        int sum = psum[ei + 1][ej + 1] - psum[ei + 1][sj] - psum[si][ej + 1] + psum[si][sj];
                        if(sum <= k){
                            res = Math.max(res, sum);
                        }
                    }
                }
            }
        }
        return res; 
        
       // return 1;
    }
}
