/*The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
  Example 1:
Input: n = 3, k = 3
Output: "213"
Example 2:
Input: n = 4, k = 9
Output: "2314"
Example 3:
Input: n = 3, k = 1
Output: "123"
  Constraints:
1 <= n <= 9
1 <= k <= n!*/
 
class Solution {
    public String getPermutation(int n, int k) {
        int[] arr=new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        String s="";
        for(int i=0;i<k-1;i++){
            nextPermutation(arr);
            //s= k(arr);
            //System.out.println(s);
        }
        
        return k(arr);
    }
    
     String k(int[] a){
        String s="";
        for(int i=0;i<a.length;i++){
            s+=a[i];
        }
         return s;
     }
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
        //System.out.println(swapel+" s "+swapat);
        if(swapel==-1){
            revrseSort(nums,0,nums.length-1); 
        }else{
            int j=nums.length-1;
            while(j>0){
                if(nums[j]>swapel){
                    //System.out.println(j+" r "+swapat);
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
        //System.out.println(start+" rev: "+end);
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
