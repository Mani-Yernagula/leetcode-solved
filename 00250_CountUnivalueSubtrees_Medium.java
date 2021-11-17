/*Given the root of a binary tree, return the number of uni-value subtrees.
A uni-value subtree means all nodes of the subtree have the same value.
  Example 1:
Input: root = [5,1,5,5,5,null,5]
Output: 4
Example 2:
Input: root = []
Output: 0
Example 3:
Input: root = [5,5,5,5,5,null,5]
Output: 6
  Constraints:
The numbrt of the node in the tree will be in the range [0, 1000].
-1000 <= Node.val <= 1000*/
 
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
    int max=0;
    public int countUnivalSubtrees(TreeNode root) {
        po(root);
        return max;
    }

    int po(TreeNode root) {
        int ret =  -2000 ;
        if (root == null) {
            return ret;
        }
        ret = root.val;
        int l = po(root.left);
        int r = po(root.right);
        if (l == -2000 && r == -2000) {
            max++;
            return ret;
        } else {
            if(l==-2000) {
                l = root.val ;
            }
            if(r== -2000) {
                r =  root.val ;
            }
        }
        
        if(root.val==l && root.val==r) {
            max++;
        }else {
            return -3000;
        }

        // System.out.println(root.val+" : "+l[0]+" : "+l[1]+" "+r[0]+" : "+r[1]);

        return ret;
    }
}
