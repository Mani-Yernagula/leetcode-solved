/*Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
  Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
  Constraints:
3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104*/
 
class Solution {
    public int threeSumClosest(int[] arr, int x) {
        Arrays.sort(arr);
        int m = 10000;
        for (int i = 0; i < arr.length - 2; i++){
            int ptr1 = i + 1, ptr2 = arr.length - 1;
             while (ptr1 < ptr2){
                int sum = arr[i] + arr[ptr1] + arr[ptr2];
                if(m==10000){
                    m = sum;
                }else if (Math.abs(x - sum) < Math.abs(x - m)){
                    m = sum;
                }
                if (sum > x){
                    ptr2--;
                }else{
                    ptr1++;
                }
            }
        }
        return m;
    }
}
