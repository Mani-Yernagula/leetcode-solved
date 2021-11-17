/*You are given a tree with n nodes numbered from 0 to n - 1 in the form of a parent array parent where parent[i] is the parent of ith node. The root of the tree is node 0. Find the kth ancestor of a given node.
The kth ancestor of a tree node is the kth node in the path from that node to the root node.
Implement the TreeAncestor class:
TreeAncestor(int n, int[] parent) Initializes the object with the number of nodes in the tree and the parent array.
int getKthAncestor(int node, int k) return the kth ancestor of the given node node. If there is no such ancestor, return -1.
  Example 1:
Input
["TreeAncestor", "getKthAncestor", "getKthAncestor", "getKthAncestor"]
[[7, [-1, 0, 0, 1, 1, 2, 2]], [3, 1], [5, 2], [6, 3]]
Output
[null, 1, 0, -1]

Explanation
TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
treeAncestor.getKthAncestor(3, 1); // returns 1 which is the parent of 3
treeAncestor.getKthAncestor(5, 2); // returns 0 which is the grandparent of 5
treeAncestor.getKthAncestor(6, 3); // returns -1 because there is no such ancestor
  Constraints:
1 <= k <= n <= 5 * 104
parent.length == n
parent[0] == -1
0 <= parent[i] < n for all 0 < i < n
0 <= node < n
There will be at most 5 * 104 queries.*/
 
class TreeAncestor {
    
    int[][] ancestors;
    int rows;
    
    // initialization: Time: n * log(n)   Space: n * log(n) 
    public TreeAncestor(int n, int[] parent) {
        this.rows = (int)(Math.log(n) / Math.log(2)) + 1;
        this.ancestors = new int[rows][n];

        
        ancestors[0] = parent;
        for (int r = 1; r < rows; r++) {
            for (int i = 0; i < n; i++) {
                int temp = ancestors[r-1][i];
                ancestors[r][i] = (temp == -1) ? -1 : ancestors[r-1][temp];
              //  System.out.print(","+ancestors[r][i]);
            }
            //System.out.println();
        } 
    }
    
    public int getKthAncestor(int node, int k) {
        int pow=0;
        while(k!=0){
            if((k & 1) ==1){
               node = ancestors[pow][node];
               if(node==-1){
                    break;
               }
            }
            pow++; 
            k = k>>1;
        }
        return node;
    }
    
    
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
