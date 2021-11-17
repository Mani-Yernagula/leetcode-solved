/*Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
If two nodes are in the same row and column, the order should be from left to right.
  Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Example 2:
Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]
Example 3:
Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
Output: [[4],[9,5],[3,0,1],[8,2],[7]]
Example 4:
Input: root = []
Output: []
  Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100*/
 
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> li =new ArrayList<List<Integer>> ();
        if(root==null){
            return li;
        }
        
        Map<Integer,List<Integer>> m =new HashMap<Integer,List<Integer>>();
        int x=0;
        verticalOrder(root,m,0);
        //System.out.println(min+" : "+m);
        
        int k=0;
        while(k<m.size()){
            li.add(m.get(min));
            k++;
            min++;
        }
        return li;
        
        
    }
    
    void  verticalOrder(TreeNode root,Map<Integer,List<Integer>> m,int lvl) {
        
        
        
        Queue<List> q = new LinkedList<List>();
        List t = new ArrayList();
        t.add(root);
        t.add(lvl);
        q.add(t);
        while(!q.isEmpty()){
            //System.out.println(" : "+m);
            List tli =q.remove();
            TreeNode c =(TreeNode)tli.get(0);
            lvl = (int)tli.get(1);
            List<Integer> li =null;
            if(m.containsKey(lvl)){
               li = m.get(lvl);
            }else{
               li = new ArrayList<Integer>();
            }
           // System.out.println(" : "+c.val);
            li.add(c.val);
            m.put(lvl,li);
            min=lvl<min?lvl:min;
            
            if(c.left!=null){
                List l = new ArrayList();
                l.add(c.left);
                l.add(lvl-1);
                q.add(l);
            }

            if(c.right!=null){
                List r = new ArrayList();
                r.add(c.right);
                r.add(lvl+1);
                q.add(r);
            }
        }
        
        
        
    }
}
