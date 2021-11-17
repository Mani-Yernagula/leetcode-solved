/*Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
Two nodes of a binary tree are cousins if they have the same depth with different parents.
Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
  Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
  Constraints:
The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.*/
 
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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        int[] a = getParentAndDepth(root,x,-1,0);
        int[] b = getParentAndDepth(root,y,-1,0);
        if(a==null || b==null)
        return false;
        else
            return a[0]!=b[0] && a[1]==b[1];
    }
    
    int[] getParentAndDepth(TreeNode root, int x,int p,int d) {
        int[] r = new int[2];
        if(root==null){
            return null;
        }else if(root.val==x){
            r[0]=p;
            r[1]=d;
        }else{
           r = getParentAndDepth(root.left,x,root.val,d+1);
           if(r==null)
           r = getParentAndDepth(root.right,x,root.val,d+1);
        }
        return r;
    }
}
