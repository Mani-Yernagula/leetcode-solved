/*You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
  Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
  Constraints:
The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
  Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?*/
 
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
    
   
    
    public void recoverTree(TreeNode root) {
        traverse(root);
    }
    
    public void traverse(TreeNode root){
        // System.out.println("IN");
        Stack<TreeNode> st =new Stack<TreeNode>();
        st.add(root);
        TreeNode c = root;
        TreeNode l=null;
        while (!st.isEmpty()) {
            if (c == null) {
                TreeNode p = st.pop();
                //System.out.println(p.val);
                if(l!=null && l.val>p.val){
                    swap(l,p);
                    traverse(root);
                    break;
                }
                l=p;
                if (p.right != null) {
                    st.push(p.right);
                    c = p.right;
                }
                continue;
            }

            
            if (c.left != null) {
                st.push(c.left);
                c = c.left;
                continue;
            }else{
                c =null;
            }
        }   
    }
    
    private void swap(TreeNode l,TreeNode c){
            int t = l.val;
            l.val = c.val;
            c.val = t;
         
    }
}
