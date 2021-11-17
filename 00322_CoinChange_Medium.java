/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
  Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1
Example 3:
Input: coins = [1], amount = 0
Output: 0
Example 4:
Input: coins = [1], amount = 1
Output: 1
Example 5:
Input: coins = [1], amount = 2
Output: 2
  Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104*/
 
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<=0){
            return 0;
        }
        Arrays.sort(coins);
        return coinChangeU(coins,amount,new HashMap<Integer,Integer>());
    }
    public int coinChangeU(int[] coins, int amount,Map<Integer,Integer> m) {
        //System.out.println(amount);
        if(m.containsKey(amount))
            return m.get(amount);
        int ret=Integer.MAX_VALUE;
        for(int i=coins.length-1;i>-1;i--){
            int diff = amount - coins[i];
            if(diff>0){
                int k=0;
                //System.out.println(i+" : "+amount);
                if((k=coinChangeU(coins, diff,m))>0){
                    k++;
                    ret = k<ret?k:ret;
                }
            }
            else if(diff==0){
                //System.out.println("match");
                return 1;
            }
        }
        ret =ret==Integer.MAX_VALUE?-1:ret;
        //System.out.println("ret"+ret);
        m.put(amount,ret);
        return  ret;
    }
}
