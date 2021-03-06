/*You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
Return the maximum score of a pair of sightseeing spots.
  Example 1:
Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
Example 2:
Input: values = [1,2]
Output: 2
  Constraints:
2 <= values.length <= 5 * 104
1 <= values[i] <= 1000*/
 
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int max= Integer.MIN_VALUE;
        int n= values.length;
        int dp[]= new int[n];
       
        dp[0]= values[0];
        dp[1]= values[0]+ values[1] -1;
        
        max= Math.max(dp[0], dp[1]);
        
        for(int i=2 ; i< n; i++){
            dp[i]= Math.max(values[i-1]+values[i]-1, ((dp[i-1]-values[i-1])+values[i]-1));
            max= Math.max(max, dp[i]);                
            
        }
        return max;
    }
}
