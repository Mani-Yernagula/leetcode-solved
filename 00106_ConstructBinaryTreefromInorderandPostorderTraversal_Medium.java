/*Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
  Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]
  Constraints:
1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.*/
 
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> po = new ArrayList<Integer>();
        List<Integer> in = new ArrayList<Integer>();
        for(int i:postorder){
            po.add(i);
        }
        for(int i:inorder){
            in.add(i);
        }
        return buildTree(in,po);
    }
    
    public TreeNode buildTree(List<Integer> in, List<Integer> po) {
        if(in.isEmpty() || po.isEmpty()){
            return null;
        }
        int ind = in.indexOf(po.get(po.size()-1));
        TreeNode root = new TreeNode(po.get(po.size()-1));
        //System.out.println(in+" : "+po+" : "+root.val);
        po.remove(po.size()-1);
        TreeNode r = buildTree(in.subList(ind+1,in.size()),po);
        TreeNode l = buildTree(in.subList(0,ind),po);
        
        root.left=l;
        root.right=r;
        return root;
    }
}
