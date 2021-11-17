/*There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
  Example 1:
Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
Example 2:
Input: n = 1, edges = []
Output: [0]
Example 3:
Input: n = 2, edges = [[1,0]]
Output: [1,1]
  Constraints:
1 <= n <= 3 * 104
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
The given input represents a valid tree.*/
 
class Solution {
    
    int[] res, count; ArrayList<HashSet<Integer>> tree; int n;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        n = N;
        for (int i = 0; i < N ; ++i ) tree.add(new HashSet<Integer>());
        for (int[] e : edges) {tree.get(e[0]).add(e[1]); tree.get(e[1]).add(e[0]);}
        dfs(0, new HashSet<Integer>());
        for(int i:count){
            System.out.print(","+i);
        }
        System.out.println(",");
        for(int i:res){
            System.out.print(","+i);
        }
        
        dfs2(0, new HashSet<Integer>());
        return res;
    }

    public void dfs(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root))
            if (!seen.contains(i)) {
                dfs(i, seen);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }
        count[root]++;
    }


    public void dfs2(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root))
            if (!seen.contains(i)) {
                res[i] = res[root] - count[i] + n - count[i];
                dfs2(i, seen);
            };
    }
    
    
    class Node{
        int val;
        List<Node> adj = new ArrayList<Node>();
        Map<Integer,Integer> ca = new HashMap<Integer,Integer>();
        public Node(int val){
            this.val=val;
        }
    }
    public int[] sumOfDistancesInTree1(int n, int[][] edges) {
        int[] ret = new int[n];
        Map<Integer,Node> mapAll  = bt(edges);
        Node root = mapAll.get(0);
        
        if(root==null){
            return ret;
        }
        
       // p(root,new HashSet<Integer>());
        ct(root,new HashSet<Integer>());
      //  p(root,new HashSet<Integer>());
        
        int k=0;
        while(k<n){
            Node c = mapAll.get(k);
            Map<Integer,Integer> tot = new HashMap<Integer,Integer>();
            tot.putAll(c.ca);
       
            int dd =  c!=null?dc(c,tot,1):0;
            ret[k] = dd;
            k++;
        }
     //   System.out.println("-------------");
        return ret;
    }
    
    int dc(Node c,Map<Integer,Integer> tot,int lvl){
        
        
        for(Node ad:c.adj){
            if(!tot.containsKey(ad.val)){
                Iterator<Integer> itr1 = ad.ca.keySet().iterator();
                   while(itr1.hasNext()){
                         int k=itr1.next();
                         int v=ad.ca.get(k);
                         if(!tot.containsKey(k))
                         tot.put(k,v+lvl);
                   }
                return  dc(ad,tot,lvl+1);    
            }
        }
        
        int r=0;
        for(int i:tot.values()){
            r+=i;
        }
       // System.out.println(tot+" : "+r);
        return r;
    }
    
    Map<Integer,Node> bt(int[][] edges){
        Map<Integer,Node> map = new HashMap<Integer,Node>();
        for(int i=0;i<edges.length;i++){
            int[] x = edges[i];
            int s = x[0];
            int b = x[1];
            
            Node p =map.containsKey(s)?map.get(s):new Node(s);
            Node c =map.containsKey(b)?map.get(b):new Node(b);
            
            p.adj.add(c);  
            c.adj.add(p);
            map.put(p.val,p);
            map.put(c.val,c);
            
        }
        return map;
    }
    
    Map<Integer,Integer> ct(Node root,Set<Integer> vi){
        if(root==null)
            return null;
        
        root.ca.put(root.val,0);
        vi.add(root.val);
        if(root.adj.isEmpty()){
            return root.ca;
        }
        
        for(int i=0;i<root.adj.size();i++){
            if(!vi.contains(root.adj.get(i).val)){
                 Map<Integer,Integer> map = ct(root.adj.get(i),vi);
                 Iterator<Integer> itr = map.keySet().iterator();
                 while(itr.hasNext()){
                     int k=itr.next();
                     int v=map.get(k);
                     root.ca.put(k,v+1);
                 }
            }
        }
        return root.ca;
    }
    
    void p(Node root,Set<Integer> vi){
        if(root==null)
            return ;
        System.out.println(root.val+" : "+root.ca);
        vi.add(root.val);
        for(int i=0;i<root.adj.size();i++){
            if(!vi.contains(root.adj.get(i).val))
            p(root.adj.get(i),vi);
        }
        
        
    }
}
