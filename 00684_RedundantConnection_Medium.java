/*In this problem, a tree is an undirected graph that is connected and has no cycles.
You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
  Example 1:
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:
Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
  Constraints:
n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.*/
 
class Solution {
    // simple approach by indices
    public int[] findRedundantConnection(int[][] edges) {
        int[] ret =null;
        List<Set<Integer>> vs = new ArrayList<Set<Integer>>();
         for(int i=0;i<edges.length;i++){
            int[] a = edges[i];
             boolean exists = false;
            System.out.println(a[0]+" , "+a[1]);
            System.out.println(vs);
             int l=0;
             Set<Integer> temp=null;
            for(Set o :vs){
                boolean x =o.contains(a[0]);
                boolean y = o.contains(a[1]);
                if(x || y){
                    l++;
                    exists = true;
                    if(x&&y){
                        return a; 
                    }else{
                        if(x){
                            o.add(a[1]);            
                        }else{
                            o.add(a[0]);   
                        }
                    }
                    if(l==2){
                        o.addAll(temp);
                        temp.clear();
                    }
                    temp = o;
               }
            }
            if(!exists){
                Set<Integer> k= new HashSet<Integer>();
                k.add(a[0]);k.add(a[1]);
                vs.add(k);
            }
         }
        
        
        /*for(int i=0;i<edges.length;i++){
            int[] a = edges[i];
            buildGraph(a);
            System.out.println(map);
            if(hasloop()){
                return a;
            }
        }*/
        System.out.println("------------------");
        return ret;
    }
    
    
    Queue<V> q =new LinkedList<V>();
    Set<Integer> s = new HashSet<Integer>();
    Set<String> e = new HashSet<String>();
    HashMap<Integer,V> map =new HashMap<Integer,V>();
    class V{
        int val;
        List<Integer> adv =new ArrayList<Integer>();
        public V(int val){
            this.val=val;
        }
        public String toString(){
            return val+" : "+adv;
        }
    }
    
    private void buildGraph(int[] ver){
        // for(int i=0;i<edges.length;i++){
            //int[] ver =edges[i];
            if(!map.containsKey(ver[0])){
                V v =new V(ver[0]);
                v.adv.add(ver[1]);
                map.put(ver[0],v);
            }else{
                V v= map.get(ver[0]);
                v.adv.add(ver[1]);
            }
            
            if(!map.containsKey(ver[1])){
                V v1 =new V(ver[1]);
                v1.adv.add(ver[0]);
                map.put(ver[1],v1);
            }else{
                V v1 = map.get(ver[1]);
                v1.adv.add(ver[0]);
            }
       // }
    }
    
    private boolean hasloop(){
        Iterator i = map.keySet().iterator();
        while(i.hasNext()){
            V v = map.get(i.next());
            
            q.add(v);
            s.clear();
            e.clear();
            while(!q.isEmpty()){
                //System.out.println(q+" : "+s+ " : "+e);
                V c =q.remove();
                if(s.contains(c.val)){
                    return true;
                }
                s.add(c.val);
                for(int adj:c.adv){
                   if(!e.contains(adj+","+c.val)){ 
                      q.add(map.get(adj));
                      e.add(c.val+","+adj);
                   }
                }
            }
        }
        return false;
        
    }
}
