/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
  Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.*/
 
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int c=0;
        ListNode rt=new ListNode();
        ListNode head = rt;
        while(l1 !=null && l2 !=null){
            int x =l1.val+l2.val+c;
            c = x/10;
            x = x%10;
            ListNode t=new ListNode(x);
            rt.next=t;
            rt = t;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int x =l1.val+c;
            c = x/10;
            x = x%10;
            ListNode t= new ListNode(x);
            rt.next =t;
            rt = t;
            l1=l1.next;
        }
        while(l2!=null){
           int x =l2.val+c;
            c = x/10;
            x = x%10;
            ListNode t= new ListNode(x);
            rt.next =t;
            rt = t;
            l2=l2.next;
        }
        if(c!=0){
            ListNode t= new ListNode(c);
            rt.next =t;
        }
        return head.next;
    }
}
