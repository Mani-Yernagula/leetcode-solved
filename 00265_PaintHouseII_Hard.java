/*There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by an n x k cost matrix costs.
For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
Return the minimum cost to paint all houses.
  Example 1:
Input: costs = [[1,5,3],[2,9,4]]
Output: 5
Explanation:
Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
Example 2:
Input: costs = [[1,3],[2,4]]
Output: 5
  Constraints:
costs.length == n
costs[i].length == k
1 <= n <= 100
2 <= k <= 20
1 <= costs[i][j] <= 20
  Follow up: Could you solve it in O(nk) runtime?*/
 
class Solution {
    public int minCostII(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];
        int ret = 30000;
        //System.out.println(dp[0][0]+","+dp[0][1]+","+dp[0][2]);
        int k[]=new int[2],l[]=new int[2];
        for(int i=0;i<costs.length;i++){
            int k1=1000,l1=1000;
            PriorityQueue<int[]> pq =new PriorityQueue(new Comparator<int[]>(){
                public int compare(int[] i,int[] j){
                    return j[0]-i[0];
                }
            });
            for(int j=0;j<costs[0].length;j++){
                int prev = 0;
                if(i>0)
                prev = j==l[1]?k[0]:l[0];
                dp[i][j] = costs[i][j]+ prev;
                int[] co =new int[2];
                co[0] = dp[i][j];
                co[1] = j;
                pq.add(co);
                if(pq.size()==3)
                    pq.poll();
                //System.out.print(","+dp[i][j]);
            }
            //System.out.println(""+pq);
            k=pq.poll();
            l=pq.poll();
            //
        }
        return l[0];
    }
}
