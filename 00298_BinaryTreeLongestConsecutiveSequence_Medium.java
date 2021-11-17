/*Given the root of a binary tree, return the length of the longest consecutive sequence path.
The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path needs to be from parent to child (cannot be the reverse).
  Example 1:
Input: root = [1,null,3,2,4,null,null,null,5]
Output: 3
Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:
Input: root = [2,null,3,2,null,1]
Output: 2
Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
  Constraints:
The number of nodes in the tree is in the range [1, 3 * 104].
-3 * 104 <= Node.val <= 3 * 104*/
 
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
    int fret = -1;
    public int longestConsecutive(TreeNode root) {
        int[] ret = dfs(root);
        //System.out.println("------------");
        return fret!=-1?fret+1:fret;
    }
    
    int[] dfs(TreeNode root){
        int[] ret = new int[2];
        if(root==null){
            return ret;
        }
        ret[1] = root.val;
        int[] l =dfs(root.left);
        int[] r =dfs(root.right);
        
        //System.out.println(": "+l[0]+": "+l[1]+": "+r[0]+": "+r[1]);
        
        if(l[1]==root.val+1){
            ret[0] = l[0]+1;
        }
        if(r[1]==root.val+1){
            ret[0] = Math.max(ret[0],r[0]+1);
        }

       fret =  Math.max(ret[0],fret);
           
        //System.out.println(root.val+" : "+ret[0]+" : "+ret[1]);
        return ret;
    }
}
