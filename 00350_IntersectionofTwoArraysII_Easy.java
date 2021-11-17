/*Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
  Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
  Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
  Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?*/
 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] a = m>n?nums2:nums1;
        int[] b = m>n?nums1:nums2;
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0; i < b.length; i++){
            if(map.containsKey(b[i])){
                int c= map.get(b[i]);
                map.put(b[i],c+1);
            }else{
                map.put(b[i],1);
            }
            // System.out.println(map);
        }
       
        List<Integer> ret =new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                ret.add(a[i]);
                int c = map.get(a[i]);
                c--;
                if(c==0){
                    map.remove(a[i]);        
                }else{
                    map.put(a[i],c);
                }
            }
        }
        //System.out.println(ret);
        int[] fin = new int[ret.size()];
        for (int i=0; i < fin.length; i++)
        {
            fin[i] = ret.get(i);
        }
        return fin;
    }
    
}
