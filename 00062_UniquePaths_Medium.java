/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
  Example 1:
Input: m = 3, n = 7
Output: 28
Example 2:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:
Input: m = 7, n = 3
Output: 28
Example 4:
Input: m = 3, n = 3
Output: 6
  Constraints:
1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.*/
 
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0 && n==0)
            return 0;
        if(m==0 && n!=0)
            return n;
        if(m!=0 && n==0)
            return m;
        
        int[][] a = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            a[i][0]=0;
        }  
        for(int i=0;i<n+1;i++){
            a[0][i]=0;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                //System.out.println(i+":"+j);
                //System.out.println(a[i-1][j]+":"+a[i][j-1]);
                //System.out.println(a[i-1][j]+a[i][j-1]);
                a[i][j]=Math.max(a[i-1][j]+a[i][j-1],1);
            }
        }
        return a[m][n];
    }
}
