/*Given the head of a linked list, return the list after sorting it in ascending order.
  Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:
Input: head = []
Output: []
  Constraints:
The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
  Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?*/
 
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
    
    
    public ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        return qs(head);
    }
    
    private ListNode qs(ListNode head){
        
        if(head!=null && head.next==null){
            return head;
        }
        int sum = 0, count = 0, value = head.val;
        boolean same = true;
        ListNode currentNode=head;
        while(currentNode != null){
            if(currentNode.val!=value)
                same = false;
            sum += currentNode.val;
            currentNode = currentNode.next;
            count++;
        }
        
        if(same) // all values are the same
            return head;
        
        double pivot = 0.0;
         pivot = 1.0*sum/count;
        //System.out.println(pivot);
        
       // int p = head.val;
       // ListNode pi=head; 
        ListNode l=null;
        ListNode l1=null;
        ListNode r=null;
        ListNode r1=null;
        //head = head.next;
        //pi.next = null;
        
        while(head!=null){
            if(head.val<pivot){
                if(l==null){
                    l=head;
                    l1 = l;
                }else{
                    l.next = head;
                    l = l.next;
                }
                head = head.next;
                l.next = null;
            }else{
                if(r==null){
                    r=head;
                    r1 = r;
                }else{
                    r.next = head;
                    r = r.next;
                }
                head = head.next;
                r.next = null;
            }
        }
        //p(l1);
        //p(r1);
        
        if(l1!=null){
            l1 = qs(l1);
            l = l1;
            while(l.next!=null){
                l=l.next;
            }
        }
        
        
        if(r1!=null){
            r1 = qs(r1);
            if(l1!=null)
            l.next = r1; 
        }
        
       return l1;
      
        
    }
    void p(ListNode s){
        ListNode k =s;
        while(k!=null){
            System.out.println(k.val);
            k=k.next;
        }
         System.out.println("-----------------");
    }
}
