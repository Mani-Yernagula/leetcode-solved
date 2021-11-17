/*There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
  Example 1:
Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
Example 2:
Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
  Constraints:
1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n*/
 
class Solution {
    int m_, n_ ;int[][][] dp_;
    
   
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp_ = new int[maxMove+1][m][n];
        m_ = m;
        n_ = n;
        return paths(maxMove,startRow,startColumn);
    }
    
    static int kMod = 1000000007;
    
    int paths(int N, int x, int y) {  
       // System.out.println(" : "+N+" : "+x+" : "+y);
        // 
        
        if (x < 0 || x >= m_ || y < 0 || y >= n_) return 1;
        if (N == 0) return 0;
        ////System.out.println(" : "+dp_[N][x][y]);
        if (dp_[N][x][y] != 0) return dp_[N][x][y];
        if (N> 0 && N <x &&  N < y && N<m_-1-x &&   N<n_-1-y) {//additinal optimization when N cant anyways reach the bondary
            //System.out.println(" : "+N+" : "+(x)+" : "+(y));
            return 0;
                                                };
    
        long ans = 0;
        ans += paths(N - 1, x + 1, y);
        ans += paths(N - 1, x - 1, y);
        ans += paths(N - 1, x, y + 1);
        ans += paths(N - 1, x, y - 1);
        ans %= kMod;
        //System.out.println(" "+N+"["+x+"]["+y+"] = "+ans);
        return dp_[N][x][y] = (int) ans;
   }
}
