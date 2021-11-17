/*Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
  Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
  Constraints:
The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104*/
 
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
    boolean isB=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return true;
        if(root.val==subRoot.val){
            if(!isB){
                isB= isSameTree(root,subRoot);
            }
        }
        isSubtree(root.left,subRoot);
        isSubtree(root.right,subRoot);
        return isB;
    }
    
    boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null){
            return true;
        }else if (root!=null && subRoot!=null){
            return root.val==subRoot.val &&
                isSameTree(root.left,subRoot.left) && 
                isSameTree(root.right,subRoot.right);
        }else{
            return false;
        }
        
    }
}
