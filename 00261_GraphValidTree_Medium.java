/*You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
Return true if the edges of the given graph make up a valid tree, and false otherwise.
  Example 1:
Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true
Example 2:
Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false
  Constraints:
1 <= 2000 <= n
0 <= edges.length <= 5000
edges[i].length == 2
0 <= ai, bi < n
ai != bi
There are no self-loops or repeated edges.*/
 
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<List<Integer>>();
        Set<Integer> vio = new HashSet<Integer>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<Integer>());
            vio.add(i);
        }
        
        for(int[] e:edges){
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        
        
        //System.out.println(g);
        Set<Integer> vi = new HashSet<Integer>();
        dfs(-1,0,g.get(0),g,vi);
        vio.removeAll(vi);
        return vio.isEmpty();  
    }
    
    boolean dfs(int p,int c,List<Integer> nodes,List<List<Integer>> g,Set<Integer> vi){
        
        if(vi.contains(c)){
            return false;
        }
        vi.add(c);
        
        for(int e:nodes){
            if(e!=p && !dfs(c,e,g.get(e),g,vi)){
                vi.remove(c);
                return false;
            }
        }
        return true;
    }
}
