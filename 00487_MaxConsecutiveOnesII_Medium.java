/*Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
  Example 1:
Input: nums = [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the maximum number of consecutive 1s. After flipping, the maximum number of consecutive 1s is 4.
Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 4
  Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
  Follow up: What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?*/
 
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curCount = 0;
        int maxCount = 0;
        int prevCount = 0;
        int atLeastOneO=-1;
        for(int i = 0; i < nums.length; i++) {
          if(nums[i] == 1) {
            curCount++;
          } else {
             int t = prevCount+(atLeastOneO==-1?0:1)+curCount;
            maxCount = Math.max(maxCount, t);
            prevCount = curCount;
            atLeastOneO=0;  
            curCount = 0;
          }
        }
        return Math.max(maxCount, prevCount+(atLeastOneO==-1?0:1)+curCount);
    }
}
