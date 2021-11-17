/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
  Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:
Input: nums = [1,2,3]
Output: 3
  Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000*/
 
class Solution {
    public int rob(int[] nums) {
        if(nums==null)
            return 0;
        
        if(nums.length==1)
            return nums[0];
         
        int ret= Math.max(nums[0],nums[1]);
        if(nums.length==2)
            return ret;
        if(nums.length==3)
            return Math.max(ret,nums[2]);
        
        int[] dp = new int[nums.length];
        int n=nums.length;
        int i=0;
        i=2;
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        //System.out.print(dp[0]+","+dp[1]);
        for(;i<n-1;i++){ 
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            //System.out.print(","+dp[i]);
        }
        //System.out.println("");
        int x = dp[i-1];
        dp = new int[nums.length];
        i=3;
        dp[1] = nums[1];
        dp[2] = Math.max(dp[1], nums[2]);
        //System.out.print(dp[1]+","+dp[2]);
        for(;i<n;i++){ 
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            //System.out.print(","+dp[i]);
        }
        //System.out.println("");
        int y = dp[i-1];
        
        return Math.max(x,y);
    }
}
