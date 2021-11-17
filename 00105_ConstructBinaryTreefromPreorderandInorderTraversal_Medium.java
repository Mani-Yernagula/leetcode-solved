/*Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
  Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
  Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.*/
 
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> in = new ArrayList<Integer>();
        for(int i:preorder){
            pre.add(i);
        }
        for(int i:inorder){
            in.add(i);
        }
        return buildTree(in,pre);
    }
    
    public TreeNode buildTree(List<Integer> in, List<Integer> pre) {
        if(in.isEmpty() || pre.isEmpty()){
            return null;
        }
        int ind = in.indexOf(pre.get(0));
        TreeNode root = new TreeNode(pre.get(0));
        pre.remove(0);
        TreeNode l = buildTree(in.subList(0,ind),pre);
        TreeNode r = buildTree(in.subList(ind+1,in.size()),pre);
        root.left=l;
        root.right=r;
        return root;
    }
}
