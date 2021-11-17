/*Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
  Example 1:
Input: root = [4,2,5,1,3], target = 3.714286, k = 2
Output: [4,3]
Example 2:
Input: root = [1], target = 0.000000, k = 1
Output: [1]
  Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104.
0 <= Node.val <= 109
-109 <= target <= 109
  Follow up: Assume that the BST is balanced. Could you solve it in less than O(n) runtime (where n = total nodes)?*/
 
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> li  =new ArrayList<Integer>();
        PriorityQueue<double[]> p =new PriorityQueue<double[]>(new Comparator<double[]>(){
            public int compare(double[] d1,double[] d2){
                return Math.abs(d2[0])-Math.abs(d1[0])>0?1:-1;
            }
        });
        in(root,target,k,p);
        for(double[] a:p){
            li.add((int)a[1]);
        }
        return li;
    }
    
    void in(TreeNode root,double target, int k,PriorityQueue<double[]> p){
        if(root==null){
            return ;
        }
        in(root.left,target,k,p);
        
        double[] a = new double[2];
        a[0] = target-root.val;
        a[1] = root.val;
        p.add(a);
        if(p.size()>k){
            p.remove();
        }
        in(root.right,target,k,p);
        
    }
}
