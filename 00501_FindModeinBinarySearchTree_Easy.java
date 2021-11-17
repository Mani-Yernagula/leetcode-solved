/*Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
If the tree has more than one mode, return them in any order.
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
  Example 1:
Input: root = [1,null,2,2]
Output: [2]
Example 2:
Input: root = [0]
Output: [0]
  Constraints:
The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
  Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).*/
 
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
    
    Map<Integer,Integer> m = new HashMap<Integer,Integer>();
    Set<Integer> s = new HashSet<Integer>();
    int max=0;
    
    public int[] findMode(TreeNode root) {
        traverse(root);
        for(Integer k :m.keySet()){
          if(max==m.get(k)){
              s.add(k);
          }
        }
        int[] a =new int[s.size()];
        int k=0;
        for(Integer e :s){
            a[k++]=e;
        }
        return a;
    }
    
     public void traverse(TreeNode root){
        if(root==null){
            return;
        } 
         
        if(root.left!=null){
            traverse(root.left);
        }
         System.out.println(root.val);
        if(m.containsKey(root.val)){
           int k=m.get(root.val)+1;
           m.put(root.val,k);
           max=max<k?k:max;
        }else{
           m.put(root.val,1);
           max=max<1?1:max;
        }
        if(root.right!=null){
            traverse(root.right);
        }
    }
}
