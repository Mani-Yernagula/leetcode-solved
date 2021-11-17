/*Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
  Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:
Input: nums = [1,1]
Output: [2]
  Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
  Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.*/
 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=1;
        List<Integer> li =new ArrayList<Integer>();
        while(i<=nums.length){
            li.add(i);
            i++;
        }
        
        for(int k:nums){
            li.set(k-1,0);
        }
        List<Integer> li1 =new ArrayList<Integer>();
        for(int k:li){
            if(k!=0)
            li1.add(k);
        }
        return li1;
        
    }
}
