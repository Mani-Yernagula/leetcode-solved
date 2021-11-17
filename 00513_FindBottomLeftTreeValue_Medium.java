/*Given the root of a binary tree, return the leftmost value in the last row of the tree.
  Example 1:
Input: root = [2,1,3]
Output: 1
Example 2:
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
  Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1*/
 
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
    public int findBottomLeftValue(TreeNode root) {
        Stack<TreeNode> st =new Stack<TreeNode>(); 
        Queue<TreeNode> q =new LinkedList<TreeNode>(); 
        q.add(root);
        int i = q.size();
        while(!q.isEmpty()){
            TreeNode c = q.remove();
            i--;
            System.out.println("poped "+c.val);
            if(c.left!=null){
                q.add(c.left);
            }
            if(c.right!=null){
                q.add(c.right);
            }
            if(i==0 && q.peek()!=null){
                st.push(q.peek());
                i = q.size();
            }
        }
        if(st.isEmpty()){
            return root.val;
        }
        System.out.println("st  "+st);
        return st.pop().val;
    }
}
