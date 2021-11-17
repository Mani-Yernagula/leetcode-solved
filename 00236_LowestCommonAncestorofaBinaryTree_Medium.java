/*Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
  Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1
  Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.*/
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode roott =root;
        List<TreeNode> li1 = new ArrayList<TreeNode>();
        getPath(roott,p.val,li1);
        System.out.println(li1);
        roott =root;
        List<TreeNode> li2 = new ArrayList<TreeNode>();
        getPath(roott,q.val,li2);
        System.out.println(li2);
        int s = li1.size()>li2.size()?li2.size():li1.size();
        int l1 = li1.size()-1;
        int l2 = li2.size()-1;
        
        while(--s>-1){
            if(li1.get(l1).val==li2.get(l2).val){
                roott = li1.get(l1);
                System.out.println(roott.val);
            }else{
                break;
            }
            --l1;--l2;
        }
        return roott;
    }
    
    private boolean getPath(TreeNode root, int p,List<TreeNode> li ){
        if(root==null){
            return false;
        }
        if(root.val==p){
            System.out.println(root.val);
            li.add(root);
            return true;
        }else{
            boolean l = getPath(root.left,p,li);
            boolean r =false;
            if(!l){
                r = getPath(root.right,p,li);
            }
            if(l || r){
                System.out.println(root.val);
                li.add(root);
            }
            return l || r;
        }
    }
}
