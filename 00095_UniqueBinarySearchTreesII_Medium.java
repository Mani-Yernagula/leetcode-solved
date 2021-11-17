/*Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
  Example 1:
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:
Input: n = 1
Output: [[1]]
  Constraints:
1 <= n <= 8*/
 
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
    public List<TreeNode> generateTrees(int n) {
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=i+1;
        }
        return gt(a);
    }
    
    List<TreeNode> gt(int[] a) {
        List<TreeNode> ret =new ArrayList<TreeNode>();
        if(a.length==0){
            return null;
        }
        if(a.length==1){
            ret.add(new TreeNode(a[0]));
            return ret;
        }
        
        if(a.length==2){
            TreeNode r1 = new TreeNode(a[0]);
            if(r1.val>a[1])
                r1.left = new TreeNode(a[1]);
            else
                r1.right = new TreeNode(a[1]);
            ret.add(r1);
            
            TreeNode r2 = new TreeNode(a[1]);
            if(r2.val>a[0])
                r2.left = new TreeNode(a[0]);
            else
                r2.right = new TreeNode(a[0]);
            ret.add(r2);
            return ret;
        }
        for(int i=0;i<a.length;i++){
            int[] x = Arrays.copyOfRange(a,0,i);
            int[] y = Arrays.copyOfRange(a,i+1,a.length);
            List<TreeNode> ln = gt(x);
            List<TreeNode> rn = gt(y);
            
            if(ln!=null && rn!=null){
                for(TreeNode l:ln){
                    for(TreeNode r:rn){
                        TreeNode root = new TreeNode(a[i]);
                        root.left=l;
                        root.right=r;
                        ret.add(root);
                    }
                }
            }else {
                List<TreeNode> cn= ln==null?rn:ln;
                for(TreeNode c:cn){
                    TreeNode root = new TreeNode(a[i]);
                    if(ln!=null)
                    root.left=c;
                    else
                    root.right=c;
                    ret.add(root);
                }
            }           
            
        }
        return ret;
    }
}
