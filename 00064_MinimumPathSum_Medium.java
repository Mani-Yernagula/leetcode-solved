/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
  Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 ? 3 ? 1 ? 1 ? 1 minimizes the sum.
Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
  Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100*/
 
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=m!=0?grid[0].length:0;
        
        if(m==0 && n==0)
            return 0;
        if(m==0 && n!=0)
            return n;
        if(m!=0 && n==0)
            return m;
        
        int[][] a = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            a[i][0]=-1;
        }  
        for(int i=0;i<n+1;i++){
            a[0][i]=-1;
        }
               
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
               // System.out.println(i+":"+j);
                //System.out.println(a[i-1][j]+" min "+a[i][j-1]);
                //System.out.println(grid[i-1][j-1]);
                  int d1= a[i-1][j]>-1?a[i-1][j]:Integer.MAX_VALUE;
                  int d2= a[i][j-1]>-1?a[i][j-1]:Integer.MAX_VALUE;
                  a[i][j]= grid[i-1][j-1]+ (d1==Integer.MAX_VALUE && d2==Integer.MAX_VALUE ?0:Math.min(d1,d2));
                //System.out.println(a[i][j]);
                 
            }
        }
        return a[m][n];
    }
}
