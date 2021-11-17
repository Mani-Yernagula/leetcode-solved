/*Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.
The successor of a node p is the node with the smallest key greater than p.val.
  Example 1:
Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
Example 2:
Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.
  Constraints:
The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
All Nodes will have unique values.*/
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode inorderSuccessorNode=null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
       // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.
        if (p.right != null) {
            TreeNode leftmost = p.right;
            while (leftmost.left != null) {
                leftmost = leftmost.left;
            }
            this.inorderSuccessorNode = leftmost;
        } else {
            // Case 2: We need to perform the standard inorder traversal and keep track of the previous node.
            this.inorderCase2(root, p);
        }
        return this.inorderSuccessorNode;
    }
    
    private void inorderCase2(TreeNode node, TreeNode p) {
        if (node == null) {
            return;
        }
        
        while(p.val!=node.val){
            if(p.val<node.val){
                this.inorderSuccessorNode = node;
                node = node.left;
            }else if(p.val>node.val){
                node = node.right;
            }
        }
        
        
    }
}
