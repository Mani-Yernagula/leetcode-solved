/*There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
  Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
  Constraints:
1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]*/
 
class Solution {
    
    class Node{
        int x;
        List<Node> adj;
        
        public Node(int x){
            this.x=x;
        } 
        
        public String toString(){
            String m="";
            if(adj!=null)
            for(Node y:adj){
                m+=" "+y.x;
            }
            return x+":"+m;
        }
    }
    Map<Integer,Node> map =new HashMap<Integer,Node>();
    public int findCircleNum(int[][] isConnected) {
        for(int i=0;i<isConnected.length;i++){
            Node x = null;
            if(map.containsKey(i)){
                x =map.get(i);
            }else{
                x = new Node(i);
                map.put(i,x);
            }
            
            
            List<Node> adj =new ArrayList<Node>();
            for(int j=0;j<isConnected[0].length;j++){
                //int ind = (i * isConnected[0].length) + j;
                if(isConnected[i][j]==1){
                    if(map.containsKey(j)){
                        Node y =map.get(j);
                        adj.add(y);
                    }else{
                        Node y = new Node(j);
                        adj.add(y);
                        map.put(j,y);
                    }
                }
            }
            x.adj = adj;
            //System.out.println(x);
        }
        //System.out.println(map);
        Set<Integer> vi=new HashSet<Integer>();
        Set<Integer> ks =map.keySet();
        int i=0;
        for(Integer k : ks){
            if(!vi.contains(k)){
                i++;
                vi.add(k);
                bfs(map.get(k),vi);
            }
        }
        //System.out.println("--DONE----");
        return i;
    }
    
    void bfs(Node x,Set<Integer> vi){
        Queue<Node> q=new LinkedList<Node>();
        q.add(x);
        
        while(!q.isEmpty()){
            Node z = q.poll();
           // System.out.println("-->"+z+" : "+vi);
           // System.out.println("-->"+z.adj+" : "+vi);
            if(z.adj!=null)
            for(Node y :z.adj){
               // System.out.println("c->"+y.x);
                if(!vi.contains(y.x)){
                    q.add(y);
                    vi.add(y.x);
                }
            }
        }
       // System.out.println("--BFS DONE----");
        
    }
}
