/*Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
Note that you need to maximize the answer before taking the mod and not after taking it.
  Example 1:
Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
Example 2:
Input: root = [1,null,2,3,4,null,null,5,6]
Output: 90
Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
Example 3:
Input: root = [2,3,9,10,7,8,6,5,4,11,1]
Output: 1025
Example 4:
Input: root = [1,1]
Output: 1
  Constraints:
The number of nodes in the tree is in the range [2, 5 * 104].
1 <= Node.val <= 104*/
 
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
    int mod= 1000000000 + 7;
    
    public int maxProduct(TreeNode root) {
        int tot = tot(root);
        System.out.println(mod);
        System.out.println(tot);
        maxProduct1(root,tot);
        return (int)(max % mod);
    }
    long max=0;
    long maxProduct1(TreeNode root,int tot) {
        if(root==null){
            return 0;
        }
        long l=0,r=0;
        if(root.left!=null){
            l=maxProduct1(root.left,tot);
        }
        if(root.right!=null){
            r=maxProduct1(root.right,tot);
        }
        long x = root.val+l+r;
        long y = x * (tot-x);
        if(max<y){
           //  System.out.println(max+" "+y+" "+root.val);
            max=y;
        }
        
        return x;
    }
    
    
    int tot(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=0,r=0;
        if(root.left!=null){
            l=tot(root.left);
        }
        if(root.right!=null){
            r=tot(root.right);
        }
        return root.val+l+r;
    }
}
