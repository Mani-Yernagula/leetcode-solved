/*Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
  Example 1:
Input: nums = [1,2,2,3,1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
  Constraints:
nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.*/
 
class Solution {
    
    Map<Integer,List<Integer>> m = new HashMap<Integer,List<Integer>>();
    
    public int findShortestSubArray(int[] nums) {
        int k=0;
        int max = 0;
        for(int i:nums){
            List<Integer> indexes=new ArrayList<Integer>();
            if(m.containsKey(i)){
                indexes = m.get(i);
            }
            indexes.add(k);
            m.put(i,indexes);
            max = max<indexes.size()?indexes.size():max;
            k++;
        }
        
        int ret=Integer.MAX_VALUE;
        for(List<Integer> indexes:m.values()){
            if(max==indexes.size()){
                int d = indexes.get(indexes.size()-1)-indexes.get(0);
                ret=ret>d?d:ret;
            }
        }
        return ret+1;
    }
}
