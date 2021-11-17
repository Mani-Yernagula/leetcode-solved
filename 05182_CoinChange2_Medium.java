/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
The answer is guaranteed to fit into a signed 32-bit integer.
  Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:
Input: amount = 10, coins = [10]
Output: 1
  Constraints:
1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000*/
 
class Solution {
    
    Map<String,Integer> m = new HashMap<String,Integer>();
    
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        if(amount==0){
            return 1;
        }
        return change(amount,coins,0);
    }
    //funny me some how solved with more time :(
    public int change(int amount, int[] coins,int index) {
        if(m.containsKey(index+","+amount)) {
            return m.get(index+","+amount);
        }
        int ret =0;
        for (int i = index; i < coins.length; i++) {
            int j = coins[i];
            if(amount-j>0)
                ret += change(amount-j,coins,i);
            else if(amount-j==0){
                ret += 1;
                break;
            }else{
                break;
            }
        }
        m.put(index+","+amount,ret);
        return ret;
    }
   //classic optimal 
   public int changeg(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int x = coin; x < amount + 1; ++x) {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
  }
}
