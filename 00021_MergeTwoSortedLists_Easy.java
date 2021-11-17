/*Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
  Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:
Input: l1 = [], l2 = []
Output: []
Example 3:
Input: l1 = [], l2 = [0]
Output: [0]
  Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.*/
 
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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode r = ret;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                if(l1.val<l2.val){
                    r.next = new ListNode(l1.val);
                    l1=l1.next;
                }else{
                    r.next = new ListNode(l2.val);
                    l2=l2.next;
                }
                r=r.next;
            }else {
                ListNode t = l1!=null?l1:l2;
                while(t!=null){
                    r.next = new ListNode(t.val);
                    t=t.next;
                    r=r.next;
                }
                break;
            }
        }
        return ret.next;
    }
}
