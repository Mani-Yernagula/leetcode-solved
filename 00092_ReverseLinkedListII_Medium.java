/*Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
  Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]
  Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
  Follow up: Could you do it in one pass?*/
 
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        System.out.println("head start "+head.val );
        ListNode headt = head;
        
        if(left==1){//borrder case only
           ListNode nheadt =new ListNode(-1); 
           nheadt.next = headt;
           headt =nheadt;
        }
        int i=1,j=0; 
        while(headt.next!=null && i!=left){
            i++;
            if(i==left){
                break;
            }
            headt=headt.next;
        }
        System.out.println("head at "+headt.val +" current pos "+i);
        
        ListNode temp =null,next=null;
        
        while(headt.next!=null){
            System.out.println("p "+headt.val +" i "+i+" right "+right);
            i++;
            
            next =  headt.next.next;
            if(temp==null){
                temp = headt.next;
                temp.next = null;
            }else{
                headt.next.next = temp;
                temp = headt.next;
            }
            System.out.println("temp i "+temp.val);
            headt.next = next;
            if(i==right+1 || headt.next==null){
                //link here
                ListNode last =headt.next;
                headt.next = temp;
                if(left==1){//borrder case only
                    head =temp;
                }
                while(headt.next!=null){
                    System.out.println("temp m "+headt.next.val);
                    headt = headt.next ;
                }
                headt.next = last;
                break;
            }
        }
        
        
        return head;
        
    }
}
