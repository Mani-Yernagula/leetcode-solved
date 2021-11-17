/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
  Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:
Input: lists = []
Output: []
Example 3:
Input: lists = [[]]
Output: []
  Constraints:
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.*/
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if(size==0){
            return null;
        }else if(size==1){
            return lists[0];
        }else if(size==2){
            //merge
            ListNode a = lists[0];
            ListNode b = lists[1];
            ListNode c =null;
            ListNode d =null;
            do{
                //System.out.println("#"+(a!=null?a.val:""));
                //System.out.println("#"+(b!=null?b.val:""));
                ListNode temp = null;
                if(a==null && b==null){
                    break;
                }else if(a==null && b!=null){
                     temp =b;
                    b=b.next;
                }else if(a!=null && b==null){
                     temp =a;
                    a=a.next;
                }else if(a!=null && b!=null && a.val<b.val){
                     temp =a;
                    a=a.next;
                }else{
                    temp =b;
                    b=b.next;
                }
                if(c==null){
                    c=new ListNode(temp.val);
                    d = c;
                }else{
                    c.next = new ListNode(temp.val);
                    c=c.next;
                }
               // System.out.println("$$"+c.val);
               // System.out.println("##"+(a!=null?a.val:""));
               // System.out.println("##"+(b!=null?b.val:""));
            }
            while(a!=null || b!=null);
            return d;
        }else{
            int k=size/2;
            System.out.println("::"+k);
            ListNode[] a = new ListNode[k];
            for(int i=0;i<k;i++){
                a[i]=lists[i];
                //System.out.println("**"+a[i].val);
            }
            ListNode[] b= new ListNode[size-k];
            int l=0;
            for(int i=k;i<size;i++){
                b[l++]=lists[i];
                //System.out.println("^^"+b[l-1].val);
            }
            ListNode[] c = new ListNode[2];
            c[0] =mergeKLists(a);
            c[1] =mergeKLists(b);
            return mergeKLists(c);
        }
    }
}
