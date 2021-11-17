/*Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
  Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:
Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]
  Constraints:
1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
All the elements of arr2 are distinct.
Each arr2[i] is in arr1.*/
 
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
      LinkedList<Integer> li =new LinkedList<Integer>();
      HashMap<Integer,Node> map =new   HashMap<Integer,Node>();
      Node head =new Node(-1);
      Node t =new Node(-1);
      head.next =t;
      t.prev= head;
      Node h =head;
      for(int i=0;i<arr2.length;i++){
          Node n =new Node(arr2[i]);
          Node temp = h.next;
          n.next = temp;
          temp.prev = n;
          n.prev = h;
          h.next = n;
          h=n;
          map.put(n.val,n);
      }
        Node end = t.prev;
        end.end = true;
        Set<Integer> du = new HashSet<Integer>();
       du.addAll( map.keySet());
        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])){
                //System.out.println(arr1[i]);
                //System.out.println(du);
                if(du.contains(arr1[i])){
                    du.remove(arr1[i]);
                }else{
                   Node n =new Node(arr1[i]);
                    Node h1 = map.get(arr1[i]);
                  Node temp = h1.next;
                  n.next = temp;
                  temp.prev = n;
                  n.prev = h1;
                  h1.next = n; 
                }
            }else{
                Node n =new Node(arr1[i]);
                Node h1 = t.prev;
                while(h1.val>n.val && !h1.end){
                    h1 = h1.prev;
                }
                
                  Node temp = h1.next;
                  n.next = temp;
                  temp.prev = n;
                  n.prev = h1;
                  h1.next = n; 
            }
        }
        int[] arr3 = new int[arr1.length] ;
        int j=-1;
        while(head.next!=null ){
            head = head.next;
            if(head.val==-1){
                break;
            }
            System.out.println(head.val);
            arr3[++j] =head.val;
        }
        return arr3;
    }
    
    class Node{
        Node prev;
        Node next;
        int val;
        boolean end;
        public Node(int val){
            this.val=val;
        }
    }
}
