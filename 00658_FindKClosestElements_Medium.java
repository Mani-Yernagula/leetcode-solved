/*Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
  Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
  Constraints:
1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104*/
 
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> ret =new LinkedList<Integer>();
        
         int l = 0,u=arr.length-1;
         int mid = (l+u)/2;
         int ind =0;
          while(l<u){
              System.out.println(l+" : "+u+" - "+mid);
              if(x==arr[mid]){
                  ind=mid;
                  break;
              }
              if(x<arr[mid]){
                  u=mid-1;
              }else{
                  l=mid+1;
              }
              mid = (l+u)/2;
              
          }
        System.out.println(mid);
        ind = mid;
        
        int i=0,j=ind,m=ind+1;
                
        
        while(i<=k && i<arr.length){
            System.out.println(i+":"+j+":"+m);
            
            if(j>-1 && m<arr.length){
                int c= Math.abs(x-arr[j]);
                int d= Math.abs(x-arr[m]);
                System.out.println(c+":"+d);
                if(c<=d){
                    ret.addFirst(arr[j]);
                    j--;
                }else{
                    ret.addLast(arr[m]);
                    m++;
                }
                i++;
                continue;
            }
            if(j==-1  && m<arr.length){
                ret.addLast(arr[m]);
                m++;
                i++;
                continue;
            }
            if(j>-1 && m==arr.length){
                ret.addFirst(arr[j]);
                j--;
                i++;
                continue;
            }
        }
        
        if(ret.size()>1 && ret.size()!=k){
            int c= Math.abs(x-ret.getFirst());
            int d= Math.abs(x-ret.getLast());
            if(c<=d){
                ret.removeLast();
            }else{
                ret.removeFirst();
            }
        }
        
        System.out.println("---------------------");
        
        return ret;
        
        
    }
}
