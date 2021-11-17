/*You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
Return the number of connected components in the graph.
  Example 1:
Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:
Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
  Constraints:
1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.*/
 
class Solution {
    public int countComponents(int n1, int[][] edges) {
        List<List<Integer>> li =new ArrayList<List<Integer>>();
        int i=0;
        while(i<n1){
            li.add(new ArrayList<Integer>());
            i++;
        }
        for(int[] n:edges){
            li.get(n[0]).add(n[1]);
            li.get(n[1]).add(n[0]);
        }
        int ret=0;
        Set<Integer> vi = new HashSet<Integer>();
        i=0;
        while(i<n1){
            if(!vi.contains(i)){
                ret++;
                dfs(li,i,vi);
            }
            i++;
        }
        return ret;
    }
    
    void dfs(List<List<Integer>> li, int n,Set<Integer> vi){
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(n);
        
        while(!q.isEmpty()){
            int e =q.remove();
            //System.out.println(e);
            
            if(vi.contains(e)){
                continue;
            }
            vi.add(e);
            List<Integer> eds = li.get(e);
            for(int ed:eds){
                 if(!vi.contains(ed))
                     q.add(ed);
            }
        }
    }
}
