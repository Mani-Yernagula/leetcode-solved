/*Given the root of a binary tree, find the largest subtree, which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.
A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties:
The left subtree values are less than the value of their parent (root) node's value.
The right subtree values are greater than the value of their parent (root) node's value.
Note: A subtree must include all of its descendants.
  Example 1:
Input: root = [10,5,15,1,8,null,7]
Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one. The return value is the subtree's size, which is 3.
Example 2:
Input: root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
Output: 2
  Constraints:
The number of nodes in the tree is in the range [0, 104].
-104 <= Node.val <= 104
  Follow up: Can you figure out ways to solve it with O(n) time complexity?*/
 
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
    int fmax = 0;
        
    public int largestBSTSubtree(TreeNode root) {
        traverseIn(root);
        //System.out.println("-----------");
        return fmax;
    }
    
    int[] traverseIn(TreeNode root){
        int[] ret = new int[3];
        ret[2] = -2;
        if(root==null){
            return ret;
        }
        int[] l = traverseIn(root.left);
        int[] r = traverseIn(root.right);
        ret[0] = root.val;
        ret[1] = root.val;
        ret[2]=1;
        if(l[2]==-1 || r[2]==-1){
            ret[2]=-1;
            return ret;
        }
        if(l[2]==-2 || l[1]<root.val){
            if(l[2]!=-2){
                ret[0]=l[0];
                ret[2]+=l[2];
            }
        }else{
            ret[2]=-1;
            return ret;
        }
        
        if(r[2]==-2 || r[0]>root.val){
            if(r[2]!=-2){
                ret[1]=r[1];
                ret[2]+=r[2];
            }
        }else{
            ret[2]=-1;
            return ret;
        }
        
        fmax= Math.max(ret[2],fmax);
        
        //System.out.println(root.val+" >>>> "+ret[0]+" , "+ret[1]+" , "+ret[2]);
        return ret;
    }
    
}
