/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
  Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
  Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.*/
 
class Solution {
    public int numIslands(char[][] grid) {
        int res=0;
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Integer[]> q=new LinkedList<Integer[]>();
        Set<String> land=new HashSet<String>();
        findOneBlock(grid,q,land);
        
        while(!q.isEmpty()){
           // print((List)q);
            Integer[] c  = q.remove();
            System.out.println("O+"+c[0]+","+c[1]);;
            if(c[0]+1 < m && grid[c[0]+1][c[1]]=='1'){//row
                if(!land.contains((c[0]+1)+","+c[1])){
                    q.add(new Integer[] {c[0]+1, c[1]});
                    land.add((c[0]+1)+","+c[1]);
                }
            }
            if(c[0]-1 > -1 && grid[c[0]-1][c[1]]=='1'){//row
                if(!land.contains((c[0]-1)+","+c[1])){
                    q.add(new Integer[] {c[0]-1, c[1]});
                    land.add((c[0]-1)+","+c[1]);
                }
            }
            if(c[1]+1 < n && grid[c[0]][c[1]+1]=='1'){//col
                if(!land.contains(c[0]+","+(c[1]+1))){
                    q.add(new Integer[] {c[0], c[1]+1});
                    land.add(c[0]+","+(c[1]+1));
                }
            }
            if(c[1]-1 > -1 && grid[c[0]][c[1]-1]=='1'){//col
                if(!land.contains(c[0]+","+(c[1]-1))){
                    q.add(new Integer[] {c[0], c[1]-1});
                    land.add(c[0]+","+(c[1]-1));
                }
            }
            //System.out.println(land);
            if(q.isEmpty()){
                res++;
                findOneBlock(grid,q,land);
             }
            
        }
        return res;
    }
    
    public void findOneBlock(char[][] grid,Queue<Integer[]> q,Set<String> land){
        int m = grid.length;
        int n = grid[0].length;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !land.contains(i+","+j)){
                    q.add(new Integer[] {i, j});
                    land.add(q.peek()[0]+","+q.peek()[1]);
                    break;
                }    
            }
            if(!q.isEmpty()){
                break;
            }
        }
        if(!q.isEmpty())
        System.out.println(q.peek()[0]+","+q.peek()[1]);
        
    }
    private void print(List<Integer[]> q){
        for(Integer[] p : q){
            System.out.print("("+p[0]+","+p[1]+")");
        }
        System.out.println(".");
    }
}
