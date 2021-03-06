/*You are given a rows x cols matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.
Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (rows - 1, cols - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.
Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative return -1.
Notice that the modulo is performed after getting the maximum product.
  Example 1:
Input: grid = [[-1,-2,-3],
               [-2,-3,-3],
               [-3,-3,-2]]
Output: -1
Explanation: It's not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
Example 2:
Input: grid = [[1,-2,1],
               [1,-2,1],
               [3,-4,1]]
Output: 8
Explanation: Maximum non-negative product is in bold (1 * 1 * -2 * -4 * 1 = 8).
Example 3:
Input: grid = [[1, 3],
               [0,-4]]
Output: 0
Explanation: Maximum non-negative product is in bold (1 * 0 * -4 = 0).
Example 4:
Input: grid = [[ 1, 4,4,0],
               [-2, 0,0,1],
               [ 1,-1,1,1]]
Output: 2
Explanation: Maximum non-negative product is in bold (1 * -2 * 1 * -1 * 1 * 1 = 2).
  Constraints:
1 <= rows, cols <= 15
-4 <= grid[i][j] <= 4*/
 
class Solution {
    public int maxProductPath(int[][] grid) {
        long[][][] dp = new long[grid.length][grid[0].length][2];
        
        int mod = 1000000007;
       
        
        
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=new long[]{grid[i][j],grid[i][j]};
                    continue;
                }
                
                long[] t = null;
                long[] l = null;
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                if(i-1>-1){
                    t = dp[i-1][j];
                    max = Math.max(max,t[0]*grid[i][j]);
                    max = Math.max(max,t[1]*grid[i][j]);
                    min = Math.min(min,t[0]*grid[i][j]);
                    min = Math.min(min,t[1]*grid[i][j]);
                }
                if(j-1>-1){
                    l = dp[i][j-1];
                    max = Math.max(max,l[0]*grid[i][j]);
                    max = Math.max(max,l[1]*grid[i][j]);
                    min = Math.min(min,l[0]*grid[i][j]);
                    min = Math.min(min,l[1]*grid[i][j]);
                }
                dp[i][j]=new long[]{min,max};
            }   
        }
        
        
        long[] last=dp[grid.length-1][grid[0].length-1];
        if(last[1]>-1){
            return (int)(last[1]%mod);
        }
        return -1;
    }
}
