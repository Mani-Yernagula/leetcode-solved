/*Given an integer array arr and an integer k, modify the array by repeating it k times.
For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
As the answer can be very large, return the answer modulo 109 + 7.
  Example 1:
Input: arr = [1,2], k = 3
Output: 9
Example 2:
Input: arr = [1,-2,1], k = 5
Output: 2
Example 3:
Input: arr = [-1,-2], k = 7
Output: 0
  Constraints:
1 <= arr.length <= 105
1 <= k <= 105
-104 <= arr[i] <= 104*/
 
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod=1000000007;
        //arr =new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int x =kadane(arr);
        if(k==1){
            return x;
        }
        
        int[] arr2 = new int[arr.length*2];
        int[] arr3 = new int[arr.length*3];
        for(int i=0;i<arr.length;i++){
            arr2[i]=arr2[i+arr.length]=arr[i];
            arr3[i]=arr3[i+arr.length]=arr3[i+arr.length*2]=arr[i];
        }
        int y =kadane(arr2)%mod;
        int z =kadane(arr3)%mod;
        //System.out.println(x+" : "+y+" : "+z);
            
        
        if(z-y>0){
            int kk=1;
            int m = y ;
            while(kk<=k-2){
                m += (z-y);
                m %=mod;
                kk++;
            }
            return m;
        }else{
            return Math.max(0,Math.max(z,y));
        }
        
    }
    
    int kadane(int[] arr){
        int max=0;
        int[] dp =new int[arr.length];
        dp[0] = arr[0];
        max=arr[0];
        for(int i=1;i<arr.length;i++){
            
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            max= Math.max(max,dp[i]);
        }
       // System.out.println();
        return max;
    }
}
