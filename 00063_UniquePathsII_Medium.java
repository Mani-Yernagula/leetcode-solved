/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and space is marked as 1 and 0 respectively in the grid.
  Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
  Constraints:
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.*/
 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=m!=0?obstacleGrid[0].length:0;
        
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
        if(obstacleGrid[0][0]==0){
             a[0][1]=1;
        }
       
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
               // System.out.println(i+":"+j);
               // System.out.println(a[i-1][j]+"+"+a[i][j-1]);
                //System.out.println(a[i-1][j]+a[i][j-1]);
                if(obstacleGrid[i-1][j-1]==0){
                    
                  a[i][j]=  a[i-1][j]+a[i][j-1];
                 
                }
            }
        }
        return a[m][n];
    }
}
