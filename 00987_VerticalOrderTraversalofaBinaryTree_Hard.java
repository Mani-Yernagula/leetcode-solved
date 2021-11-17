/*Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.
  Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:
Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:
Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
  Constraints:
The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000*/
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   
     int min=0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> li =new ArrayList<List<Integer>> ();
        if(root==null){
            return li;
        }
        
        Map<Integer,List<List>> m =new HashMap<Integer,List<List>>();
        int x=0;
        verticalOrder(root,m,0,0);
        //System.out.println(min+" : "+m);
        
        int k=0;
        while(k<m.size()){
            List<List> pq = m.get(min);
            Comparator<List> comp = new Comparator<List>(){
                   public int compare(List li1,List li2){
                     //  System.out.println((((TreeNode)li2.get(0)).val)+" : "+li2.get(1)+" : "+li2.get(2));
                      // System.out.println((((TreeNode)li1.get(0)).val)+" : "+li1.get(1)+" : "+li1.get(2));
                       if((int)li1.get(2)==(int)li2.get(2)){
                           return ((TreeNode)li1.get(0)).val-((TreeNode)li2.get(0)).val;
                       }
                       return (int)li1.get(2)-(int)li2.get(2);
                   }
               };
            Collections.sort(pq,comp);
            List<Integer> ti =new ArrayList<Integer>();
            for(List r:pq){
                ti.add(((TreeNode)r.get(0)).val);
            }
            li.add(ti);
            k++;
            min++;
        }
        //System.out.println("-----------");
                       
        return li;
        
        
    }
    
    void  verticalOrder(TreeNode root,Map<Integer,List<List>> m,int lvl,int dpt) {
        
        Queue<List> q = new LinkedList<List>();
        List t = new ArrayList();
        t.add(root);
        t.add(lvl);
        t.add(dpt);
        q.add(t);
        while(!q.isEmpty()){
            //System.out.println(" : "+m);
            List tli =q.remove();
            TreeNode c =(TreeNode)tli.get(0);
            lvl = (int)tli.get(1);
            int cdpt = (int)tli.get(2);
            List<List> pq =null;
            if(m.containsKey(lvl)){
               pq = m.get(lvl);
            }else{
               pq = new ArrayList<List>();
            }
           // System.out.println(" : "+c.val);
            pq.add(tli);
            m.put(lvl,pq);
            min=lvl<min?lvl:min;
            
            if(c.left!=null){
                List l = new ArrayList();
                l.add(c.left);
                l.add(lvl-1);
                l.add(cdpt+1);
                q.add(l);
            }

            if(c.right!=null){
                List r = new ArrayList();
                r.add(c.right);
                r.add(lvl+1);
                r.add(cdpt+1);
                q.add(r);
            }
        }
        
        
        
    }
}
