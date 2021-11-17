/*The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
  Example 1:
Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
  Constraints:
The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 104*/
 
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
    public int rob(TreeNode root) {
        int[] c = robU(root);
        return Math.max(c[0],c[1]);
    }
    
    public int[] robU(TreeNode root) {
        int[] l=new int[]{0,0};
        int[] r=new int[]{0,0};
        int[] c=new int[]{0,0};
        
        if(root.left!=null){
            l = robU(root.left);
        }
        if(root.right!=null){
            r = robU(root.right);
        }
        
        c[0] = Math.max(l[1]+root.val+r[1],l[0]+r[0]);
        c[1] = Math.max(l[0]+r[0],l[1]+r[1]);
        //System.out.println(root.val+" - "+c[0]+" : "+c[1]);
        return c;
    }
}
