/*Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
  Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
  Constraints:
1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104*/
 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int e:nums){
            q.add(e);
            if(q.size()==k+1){
                q.poll();
            }
            //System.out.println(q);
        }
        return q.poll();
    }
}
