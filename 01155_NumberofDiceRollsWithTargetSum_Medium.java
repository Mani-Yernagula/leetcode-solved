/*You have d dice and each die has f faces numbered 1, 2, ..., f. You are given three integers d, f, and target.
Return the number of possible ways (out of fd total ways) modulo 109 + 7 to roll the dice so the sum of the face-up numbers equals target.
  Example 1:
Input: d = 1, f = 6, target = 3
Output: 1
Explanation: 
You throw one die with 6 faces.  There is only one way to get a sum of 3.
Example 2:
Input: d = 2, f = 6, target = 7
Output: 6
Explanation: 
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
Example 3:
Input: d = 2, f = 5, target = 10
Output: 1
Explanation: 
You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
Example 4:
Input: d = 1, f = 2, target = 3
Output: 0
Explanation: 
You throw one die with 2 faces.  There is no way to get a sum of 3.
Example 5:
Input: d = 30, f = 30, target = 500
Output: 222616187
Explanation: 
The answer must be returned modulo 10^9 + 7.
  Constraints:
1 <= d, f <= 30
1 <= target <= 1000*/
 
class Solution {
    Map<String,Integer> map =new HashMap<String,Integer>();
    int e = 1000000000+7;
    public int numRollsToTarget(int d, int f, int target) {
      // System.out.println(d+" : "+f+" : "+target);
        if(d==1){
            if(target<=f){
                return 1;
            }
            return 0;
        }
        
        int ret = 0; 
        int k=f;
        while(k>0){
            if(target-k>0){
                int z=0;
                if(!map.containsKey(d-1+","+(target-k))){
                  z=numRollsToTarget(d-1,f,target-k);
                    //System.out.println(d-1+","+(target-k)+": "+z);
                  map.put(d-1+","+(target-k),z%e);
                }
                z = map.get(d-1+","+(target-k));
                ret+=z;
                ret =ret%e;
            }
            k--;
        }
        return ret;
    }
}
