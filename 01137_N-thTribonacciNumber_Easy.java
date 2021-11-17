/*The Tribonacci sequence Tn is defined as follows: 
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.
  Example 1:
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:
Input: n = 25
Output: 1389537
  Constraints:
0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.*/
 
class Solution {
    public int tribonacci1(int n) {
        int t0=0;
        int t1=1;
        int t2=1;
        int t3=2;
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;
        
        int t = t3;
        
        int i=3;
        while(i<n){
            int tem=t;
            t = t-t0+t;
            t0 = t1;
            t1 = t2;
            t2 = tem;
            i++;
        }
        
        return t;
    }
     public int tribonacci(int n) {
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;
         
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
         
        int i=3;
        while(i<=n){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            i++;
        }
        
        return dp[n];
    }
}
