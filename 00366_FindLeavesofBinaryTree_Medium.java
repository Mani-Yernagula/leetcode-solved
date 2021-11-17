/*Given the root of a binary tree, collect a tree's nodes as if you were doing this:
Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.
  Example 1:
Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
Example 2:
Input: root = [1]
Output: [[1]]
  Constraints:
The number of nodes in the tree is in the range [1, 100].
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        int node=0;
        do{
           List<Integer> lret = new ArrayList<Integer>();
           node = findLeaves(root,lret);
           //System.out.println(lret);
           ret.add(lret); 
        }while(node!=-199);
        return ret;
    }
    
    
    
    public int findLeaves(TreeNode root,List<Integer> ret) {
        
        if(root==null)
            return -200;
        
        int l = findLeaves(root.left,ret);
        int r = findLeaves(root.right,ret);
        if(l==-200 && r==-200){
            ret.add(root.val);
            return -199;
        }
        if(l==-199){
            root.left=null;
        }
        if(r==-199){
            root.right=null;
        }
        return root.val;
    }
}
