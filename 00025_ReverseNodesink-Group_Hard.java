/*Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.
  Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Example 3:
Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
Example 4:
Input: head = [1], k = 1
Output: [1]
  Constraints:
The number of nodes in the list is in the range sz.
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz
  Follow-up: Can you solve the problem in O(1) extra memory space?*/
 
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
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode nh=new ListNode();
        ListNode ret =nh;
        if(k==1 || head ==null){
            return head;
        }
        int x = getI(head);
        x /=k;
        //System.out.println("=----"+x);
        ListNode h=head;
        ListNode c=h.next;;
        h.next = null;
        ListNode temp=null;
        int i=1,j=0;
        while(i<k && c!=null){
            i++;
            //System.out.println(i+" : "+c.val);
            temp = c.next;
            c.next = h;
            h = c;
            c = temp;
           
            if(i==k){
                i=1;
                j++;
                //p(nh.next);
                while(nh.next!=null){
                    //System.out.println(nh.val+" * ");
                    nh=nh.next;
                }
                nh.next = h;
                //p(ret.next);
                if(j==x){
                    while(nh.next!=null){
                    //System.out.println(nh.val+" * ");
                        nh=nh.next;
                    }
                    nh.next = c;
                    break;
                }
                if(c!=null){
                    h = c;
                    c = c.next;
                    h.next = null;
                    //if(h!=null && c!=null)
                    //System.out.println(h.val+" : "+c.val);
                }
                
            }
        }
        return ret.next;
    }
    
    void p(ListNode c){
        ListNode h =c;
        while(h!=null){
            System.out.println(h.val);
            h=h.next;
        }
    }
    
    int getI(ListNode c){
        ListNode h =c;
        int i=0;
        while(h!=null){
            h=h.next;
            i++;
        }
        return i;
    }
}
