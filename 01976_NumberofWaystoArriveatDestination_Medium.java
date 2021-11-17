/*You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
  Example 1:
Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ? 6
- 0 ? 4 ? 6
- 0 ? 1 ? 2 ? 5 ? 6
- 0 ? 1 ? 3 ? 5 ? 6
Example 2:
Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
  Constraints:
1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.*/
 
class Solution {
   
    int mod = 1000*1000*1000 + 7;
    
   class Node{
        List<int[]> adj =new ArrayList<int[]>();
        int minD=Integer.MAX_VALUE;
        int ways=Integer.MAX_VALUE;
        int val=-1;
        public Node(int val){
            this.val=val;
        }
        public String toString(){
            return ">>"+val+" : "+minD+" : "+ways;
        }
        public boolean equals(Object o){
            return ((Node)o).val==this.val;
        }
    }
    
    
    
    public int countPaths(int n, int[][] roads) {
        List<Node> g=new ArrayList<Node>(n);
        int i=0;
        while(i<n){
            g.add(new Node(i));
            i++;
        }
        for(int[] x:roads){
            Node cur = g.get(x[0]);;
            cur.adj.add(new int[]{x[1],x[2]});
            cur = g.get(x[1]);;
            cur.adj.add(new int[]{x[0],x[2]});
        }
        bfs(n,g);
        return g.get(n-1).ways%mod;
    }
    
    public void bfs(int n,List<Node> g){
        PriorityQueue<Node> q = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node a,Node b){
                return a.minD-b.minD;
            }
        });
        
        Node st = g.get(0);
        st.minD=0;
        st.ways=1;
        q.add(st);
        
        while(!q.isEmpty()){
            //System.out.println(q);
            Node cur = q.remove();
            //System.out.println(cur);
            if(cur.val==n-1){
                continue;
            }
            
            for(int[] ad:cur.adj){
                Node c1 = g.get(ad[0]);
                if(c1.minD>ad[1]+cur.minD){
                    c1.minD = ad[1]+cur.minD;
                    c1.ways = cur.ways;
                    if(!q.contains(c1)){
                        q.add(c1);
                    }else{
                        q.remove(c1);
                        q.add(c1);
                    }
                    
                }else if(c1.minD==ad[1]+cur.minD){
                    c1.ways = (c1.ways%mod)+(cur.ways%mod);
                    //c1.ways += cur.ways;
                   // q.add(c1);
                }
                
                
            }
        }
    
    }
}
