/*Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.
  Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:
Input: root = [1]
Output: ["1"]
  Constraints:
The number of nodes in the tree is in the range [1, 100].
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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> li =new ArrayList<String>();
        if(root==null){
            return li;
        }
        bt(root,"",li);
        return li;
    }
    
    public void bt(TreeNode root,String s,List<String> li) {
        if(root.left==null && root.right==null){
            String f= s+"->"+root.val;
            li.add(f.substring(2));
            return;
        }
        if(root.left!=null ){
            bt(root.left,s+"->"+root.val,li);
        }
        if(root.right!=null ){
            bt(root.right,s+"->"+root.val,li);
        }
    }
}
