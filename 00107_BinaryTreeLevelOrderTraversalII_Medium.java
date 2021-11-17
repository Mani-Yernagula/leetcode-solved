/*Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
  Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:
Input: root = [1]
Output: [[1]]
Example 3:
Input: root = []
Output: []
  Constraints:
The number of nodes in the tree is in the range [0, 2000].
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> li = new ArrayList<List<Integer>>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        List<Integer> p=new ArrayList<Integer>();
        if(root!=null){
            q.add(root);
        }
        int i=q.size();
        while(!q.isEmpty()){
            TreeNode c  = q.remove();
            p.add(c.val);
            i--;
            if(c.left!=null){
                q.add(c.left);
            }
            if(c.right!=null){
                q.add(c.right);
            }
            if(i==0){
                System.out.println(p);
                li.add(p);
                p=new  ArrayList<Integer>();
                i = q.size();
            }
        }
        for(int a=0;a<li.size()/2;a++){
            List<Integer> temp= li.get(li.size()-1-a);
            li.set(li.size()-1-a,li.get(a));
            li.set(a,temp);
        }
        return li;
    }
}
