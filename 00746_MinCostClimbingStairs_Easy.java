/*You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
  Example 1:
Input: cost = [10,15,20]
Output: 15
Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
Example 2:
Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
  Constraints:
2 <= cost.length <= 1000
0 <= cost[i] <= 999*/
 
class Solution {
    HashMap<String,Integer> map= new HashMap<String,Integer>();
    public int minCostClimbingStairs(int[] cost) {
        
        return minCostClimbingStairs(cost,0,(cost.length)-1);
        
    }
    
    private int minCostClimbingStairs(int[] cost,int f,int t) {
        if(f==t || t<0){
            return 0;
        }
        int s1 = t;
        int s2 = t-1;
        //System.out.println(f+" : : "+t+" : : "+s1+" : : "+s2);
        if(s2>=f){
            //System.out.println(cost[s1]+">="+cost[2]);
            int k =0;
            if(map.containsKey(0+","+(t-1))){
                k = map.get(0+","+(t-1));
            }
            int l =0;
            if(map.containsKey(0+","+(t-2))){
                l = map.get(0+","+(t-2));
            }
            int min= Math.min(cost[s2]+ (l!=0?l:minCostClimbingStairs(cost,0,t-2)),
                    cost[s1]+ (k!=0?k:minCostClimbingStairs(cost,0,t-1)));
            map.put(0+","+t,min);
            return min;
        }
        
        return cost[f]>=cost[t]?cost[f]:cost[t];
    }
}
