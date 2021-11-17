/*You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
  Example 1:
Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:
Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
  Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] < n2
Each value grid[i][j] is unique.*/
 
class Solution {
    int[] gcurr=new int[]{0,0};
    public int swimInWater(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        PriorityQueue<pi> pq = new PriorityQueue<pi>(r*c);
        Set<String> vi = new HashSet<String>(r*c);
        
        pi p =new pi(grid[0][0],new int[]{0,0});
        int min=0;
        pq.add(p);
        while(!pq.isEmpty()){
            pi pl =pq.poll();
            System.out.println(" VISITING "+pl);  
            vi.add(pl.poi[0]+","+pl.poi[1]);
            if(min<pl.val){
                min=pl.val;
            }
            if(pl.poi[0]==(r-1) && pl.poi[1]== (c-1)){
                break;
            }
            int[][] adj = getAdj(pl.poi[0],pl.poi[1]);
            for(int i=0;i<4;i++){
               int[] np = adj[i];
               if(np[0]<0 || np[0]>=r || np[1]<0 || np[1]>=c){
                   continue;
               }
               pi ap =new pi(grid[np[0]][np[1]],new int[]{np[0],np[1]});
               //System.out.println(ap+" # "+vi);  
               if(!vi.contains(ap.poi[0]+","+ap.poi[1])){
                pq.add(ap);
               }
            }
        }
        return min;    
        //return swimInWater1(grid);
    }
    
    class pi implements Comparable{
        Integer val;
        int[] poi;
        public pi(int val,int[] poi){
         this.val=val;
         this.poi=poi;
        }
        public boolean equals(Object o){
            return this.val.equals(((pi)o).val);
        }
        
        public int compareTo(Object o){
            return this.val.compareTo(((pi)o).val);
        }
        
        public String toString(){
            return this.val+" > "+this.poi[0]+" : "+this.poi[1];
        }
    }
    
    
    
   public int  swimInWaterBute(int[][] grid) {
        int i=0,j=0,min=0;
        int r = grid.length;
        int c = grid[0].length;
        String dest = (r-1)+","+(c-1);
        System.out.println("dest "+dest);
        Set<String> s =new HashSet<String>();
        s.add("0,0");
        int n=0;
        //int max= grid[0][0] >grid[r-1][c-1]?grid[0][0]:grid[r-1][c-1];
        
        int mid=-1;
        for(int k=0;k<r;k++){
            int rowm = 1000000;
            for(int l=0;l<c;l++){
               rowm = grid[k][l]<rowm? grid[k][l]:rowm;
            }
            mid = rowm>mid?rowm:mid;
        }
        
        mid= mid<grid[0][0]?grid[0][0]:mid;
        mid= mid<grid[r-1][c-1]?grid[r-1][c-1]:mid;
        
        while(mid>n){
            n++;
        }
        //n=78;
        System.out.println("*********************"+mid+":"+n);
       while(n<r*c){
           canSwim(grid,gcurr,s,n,dest);
           if(!s.contains(dest)){
               n++;
               System.out.println("# "+n);
           }else{
               break;
           }
       }
       
        return n;
            
    }
    private int[][] getAdj(int i,int j){
        int[][] adj = new int[][]{{i+1,j},{i,j+1},{i,j-1},{i-1,j}};
        return adj;
    }
    
    private int canSwim(int[][] grid,int[] curr,Set<String> s,int min,String dest){
        //System.out.println(curr[0]+":"+curr[1]+" with min "+min +" set "+s);
        int r = grid.length;
        int c = grid[0].length;
        int[][] adj=getAdj(curr[0],curr[1]);
        if((curr[0]+","+curr[1]).equals(dest)){
            return min;
        }
        for(int i=0;i<4;i++){
            int[] np = adj[i];
            if(np[0]<0 || np[0]>=r || np[1]<0 || np[1]>=c){
                continue;
            }
            //System.out.println("checking "+np[0]+":"+np[1]+"  s "+s );
            if(canSwimToNext(grid,np,s,min)){
                s.add(np[0]+","+np[1]);
                min = canSwim(grid,np,s,min,dest);
                if(s.contains(dest)){
                   return min;
                }else{
                    s.remove(np[0]+","+np[1]);
                }
            }
        }
        return min;
    }
    
    private boolean canSwimToNext(int[][] grid,int[] np,Set<String> s,int min){
        String cur = np[0]+","+np[1];
        if(!s.contains(cur)){
            if(grid[np[0]][np[1]]<=min){
                return true;
            }
        }
        return false;
    }
}
