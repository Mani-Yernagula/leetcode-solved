/*Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
  Example 1:
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:
Input: head = []
Output: []
Example 3:
Input: head = [0]
Output: [0]
Example 4:
Input: head = [1,3]
Output: [3,1]
  Constraints:
The number of nodes in head is in the range [0, 2 * 104].
-105 <= Node.val <= 105*/
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    int md=0;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        int l=0;
        ListNode h=head;
        while(h!=null){
            h=h.next;
            l++;
        }
        
        if(l==1){
            return new TreeNode(head.val);
        }
        if(l==2){
            return an(new TreeNode(head.val),new TreeNode(head.next.val));
        }
        if(l==3){
           TreeNode le= an(new TreeNode(head.next.val),new TreeNode(head.next.next.val));
           return an(le,new TreeNode(head.val));
        }
        
        h=head;
        ListNode f=head;
        ListNode lp=head;
        
        while(h!=null && f!=null && f.next!=null){
            lp=h;
            h=h.next;
            f=f.next.next;
        }
        ListNode r = h.next;
        lp.next = null;
        
        TreeNode ri = sortedListToBST(r);
        TreeNode le = sortedListToBST(head);
        TreeNode root = an(new TreeNode(h.val),ri);
        an(root,le);
        
        
        return root;
    }
    
    TreeNode an(TreeNode r,TreeNode n){
        if(r==null){
            return n;
        }
        if(r.val>n.val){
            if(r.left!=null)
            an(r.left,n);
            else{
                r.left = n;
            }
        }else{
            if(r.right!=null)
            an(r.right,n);
            else{
                r.right = n;
            }
        }
        return r;
    }
}
