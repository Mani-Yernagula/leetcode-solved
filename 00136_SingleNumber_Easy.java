/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
  Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1
  Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.*/
 
class Solution {
    public int singleNumber(int[] nums) {
        int base = (3*(10000))+1;
        System.out.println(10000);
        int[] n = new int[(6*(10000))+1];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                n[nums[i]*(-1)] = n[nums[i]*(-1)]==1?0:1;
            }else{
                n[base+nums[i]] = n[base+nums[i]]==1?0:1;
            }
            
        }
        for(int i=0;i<n.length;i++){
            //System.out.println(n[i]);
            if(n[i]==1){
                return i<base?-i:i-base;
            }
        }
        return 1;
    }
}
