/*You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
  Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
  Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.*/
 
class Solution {
    public int orangesRotting(int[][] grid) {
        
        boolean f=false;
        List<int[]> li = new ArrayList<int[]>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    int[] r =new int[2];  
                    r[0]=i;
                    r[1]=j;
                    li.add(r);
                }
            }
        } 
        int min=0;
        if(!li.isEmpty()){
        int[][] ad = new int[4][2];
        ad[0] = new int[]{0,-1};
        ad[1] = new int[]{0,1};
        ad[2] = new int[]{-1,0};
        ad[3] = new int[]{1,0};
       
        
        //Set<String> s=new HashSet<String>();
        int len=li.size();
        int c=0;
        while(!li.isEmpty()){
            c++;
            int[] r1 = li.remove(0);
            for(int i=0;i<4;i++){
                int[] tem = new int[2];
                tem[0] = r1[0]+ad[i][0];
                tem[1] = r1[1]+ad[i][1];
                if((tem[0]>-1 && tem[0]<grid.length) && (tem[1]>-1 && tem[1]<grid[0].length))
                if(grid[tem[0]][tem[1]]==1){
                  //  System.out.println(tem[0]+" : "+tem[1]);
                    grid[tem[0]][tem[1]]=3;
                    li.add(tem);
                }
            }
            if(c==len){
                min++;
                c=0;
                len = li.size();
                //System.out.println("counting  "+min);
            }
            
        }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        
        return min>0?min-1:0;       
    }
    
    
}
