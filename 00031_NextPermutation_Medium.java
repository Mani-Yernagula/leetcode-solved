/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.
  Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:
Input: nums = [1]
Output: [1]
  Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100*/
 
class Solution {
   
     public void nextPermutation(int[] nums) {
        int swapel = -1;
        int swapat = -1;
        int i=nums.length-1;
        for(;i>0;i--){
            if(nums[i]>nums[i-1]){
                swapel= nums[i-1];
                swapat = i-1;
                break;
            }
        }
        System.out.println(swapel+" s "+swapat);
        if(swapel==-1){
            revrseSort(nums,0,nums.length-1); 
        }else{
            int j=nums.length-1;
            while(j>0){
                if(nums[j]>swapel){
                    System.out.println(j+" r "+swapat);
                    int temp = nums[j];
                    nums[j]=swapel;
                    nums[swapat]=temp;
                    break;
                }
                j--;
            }
            revrseSort(nums,swapat+1,nums.length-1); 
        }
        
    }
    
    private void revrseSort(int[] nums,int start,int end){
        System.out.println(start+" rev: "+end);
        if(start>=end){
            return;
        }
        int ep =end;
        for(int i=start;i<=start+(start+end)/2 && i<ep;i++){
           // System.out.println(i+":::"+(ep));
            int temp = nums[ep];
            nums[ep]=nums[i];
            nums[i]=temp;
            ep--;
        }
    }
    
}
