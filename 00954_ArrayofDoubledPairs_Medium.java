/*Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.
  Example 1:
Input: arr = [3,1,3,6]
Output: false
Example 2:
Input: arr = [2,1,2,6]
Output: false
Example 3:
Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
Example 4:
Input: arr = [1,2,4,16,8,4]
Output: false
  Constraints:
2 <= arr.length <= 3 * 104
arr.length is even.
-105 <= arr[i] <= 105*/
 
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer,Integer> map =new HashMap<Integer,Integer> ();
        
        for(int i=0;i<arr.length;i++){
            int s=0;
            if(map.containsKey(arr[i])){
                s = map.get(arr[i]);
            }
            map.put(arr[i],s+1);
        }
       // System.out.println(map);
        List<Integer> sortedList = new ArrayList<>(map.keySet());
        Collections.sort(sortedList);
        Iterator<Integer> s=sortedList.iterator();
        while(s.hasNext() && !map.isEmpty()){
           int k= s.next();
           if(map.containsKey(k*2) && map.containsKey(k)){
               int k1 = map.get(k);
               int k2 = map.get(k*2);
               if(k1==k2){
                   map.remove(k);
                   map.remove(k*2);
               }else{
                   if(k2>k1){
                       map.put(k*2,map.get(k*2)-k1);
                       map.remove(k);
                   }else{
                       map.put(k,map.get(k)-k2);
                       map.remove(k*2);  
                   }
               }
           }
        }
      //  System.out.println(map);
        return map.isEmpty();
    }
}
