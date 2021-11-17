/*Given an m x n matrix grid where each cell is either a wall 'W', an enemy 'E' or empty '0', return the maximum enemies you can kill using one bomb. You can only place the bomb in an empty cell.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since it is too strong to be destroyed.
  Example 1:
Input: grid = [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3
Example 2:
Input: grid = [["W","W","W"],["0","0","0"],["E","E","E"]]
Output: 1
  Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 'W', 'E', or '0'.*/
 
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int ret =0;
        
        int w = grid[0].length;
        int l = grid.length * grid[0].length;
        int i=0;
        
        while(i<l){
            if(grid[i/w][i%w]=='0'){
                //System.out.println("bfs"+i);
                int c = bfs(grid,i/w,i%w);
                ret = Math.max(ret,c);
            }
            i++;
        }
        return ret;
    }
    
    int bfs(char[][] grid,int i1,int j1){
        
        int c=0;
        int i=i1;
        while(i-1>-1){
            if(grid[i-1][j1]=='E'){
                c++;
            }else if(grid[i-1][j1]=='W'){
                break;
            }
            i--;
        }
        i=i1;
        while(i+1<grid.length){
            if(grid[i+1][j1]=='E'){
                c++;
            }else if(grid[i+1][j1]=='W'){
                break;
            }
            i++;
        }
        int j=j1;
        while(j-1>-1){
            if(grid[i1][j-1]=='E'){
                c++;
            }else if(grid[i1][j-1]=='W'){
                break;
            }
            j--;
        }
        j=j1;
        while(j+1<grid[0].length){
            if(grid[i1][j+1]=='E'){
                c++;
            }else if(grid[i1][j+1]=='W'){
                break;
            }
            j++;
        }
        
        
        
        return c;
    }
}
