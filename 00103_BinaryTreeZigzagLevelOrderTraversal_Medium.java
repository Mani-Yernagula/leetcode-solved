/*Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
  Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:
Input: root = [1]
Output: [[1]]
Example 3:
Input: root = []
Output: []
  Constraints:
The number of nodes in the tree is in the range [0, 2000].
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> li = new ArrayList<List<Integer>>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        List<Integer> p=new ArrayList<Integer>();
        if(root!=null){
            q.add(root);
        }
        int i=q.size();
        boolean zig= true;
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
                zig=!zig;
                if(zig){
                    for(int a=0;a<p.size()/2;a++){
                        int temp= p.get(p.size()-1-a);
                        p.set(p.size()-1-a,p.get(a));
                        p.set(a,temp);
                    }
                }
                li.add(p);
                p=new  ArrayList<Integer>();
                i = q.size();
            }
        }
        return li;
    }
}
