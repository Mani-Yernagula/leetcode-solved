/*Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.
It is guaranteed that the answer will in the range of 32-bit signed integer.
  Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input: root = [1,3,null,5,3]
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input: root = [1,3,2,5,null,null,9,6,null,null,7]
Output: 8
Explanation: The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
  Constraints:
The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100*/
 
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
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        if(root==null){
            return 0;
        }
        root.val=1;
        q.add(root);
        q.add(new TreeNode(-1000));
        int w = q.size()-1;
        while(!q.isEmpty()){
           //System.out.println(q.size());
           TreeNode a =  q.removeFirst();
           if(a.val==-1000){
               if(!q.isEmpty()){
                   int i = q.getFirst().val;
                   int j = q.getLast().val;
                    w = Math.max(w,(j-i)+1);
                   q.add(new TreeNode(-1000));
               }
           }else{
               if(a.left!=null){
                   a.left.val = a.val*2;
                   q.add(a.left);
               }
               if(a.right!=null){
                   a.right.val = (a.val*2)+1;
                   q.add(a.right);
               }
           } 
           
        }
        return w;
    }
}
