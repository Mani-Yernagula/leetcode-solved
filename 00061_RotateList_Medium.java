/*Given the head of a linked list, rotate the list to the right by k places.
  Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
  Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109*/
 
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
    public ListNode rotateRight(ListNode head, int k) {
      
      if(head==null || head.next==null){
          return head;
      }
        
       ListNode tem = head;
        int j=1;
        while(tem.next!=null){
            j++;
            tem =tem.next;
        }
       
        j = k%j;
        
        
      ListNode temp =   head;
        
      while(j-->0){
          head =rotateRight( head) ;
      }
      return head;  
    }
    
    public ListNode rotateRight(ListNode head) {
      ListNode temp =   head;
        
      while(temp.next!=null){
          if(temp.next.next==null){
              ListNode temp2 = temp.next;
              temp.next = null;
              temp2.next = head;
              return temp2;
          }
          temp=temp.next;
      }
      return null;  
    }
}
