/*Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
  Example 1:
Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:
Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
Example 3:
Input: root = [2,1,3], k = 4
Output: true
Example 4:
Input: root = [2,1,3], k = 1
Output: false
Example 5:
Input: root = [2,1,3], k = 3
Output: true
  Constraints:
The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105*/
 
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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        return trav(root,root,k);
    }
    
    public boolean trav(TreeNode root,TreeNode cur, int k) {
        int z = k-cur.val;
        if(bs(root,z,cur))
            return true;
        if(cur.left!=null && trav(root,cur.left,k))
            return true;
        if(cur.right!=null && trav(root,cur.right,k))
            return true;
        return false;
    }
    
    boolean bs(TreeNode root, int k,TreeNode c){
        //System.out.println(root.val+" sss:"+k);
        while(root!=null){
            System.out.println(root.val+":"+k);
            if(root==c){
                if(root.val>k){
                    root = root.left;
                }else {
                    root = root.right;
                }
            }else if(root.val==k){
                return true;
            }else if(root.val>k){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return false;
    }
}
