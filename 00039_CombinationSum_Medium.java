/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
  Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:
Input: candidates = [2], target = 1
Output: []
Example 4:
Input: candidates = [1], target = 1
Output: [[1]]
Example 5:
Input: candidates = [1], target = 2
Output: [[1,1]]
  Constraints:
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500*/
 
class Solution {
    Map<Integer, List<List<Integer>>> mem = new HashMap<Integer, List<List<Integer>>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> li = new ArrayList<List<Integer>>();
        if(target<0){
            return li;
        }
        for(int i=0;i<candidates.length;i++){
            int nt = target-candidates[i];
            System.out.println("nt "+nt);
            if(nt==0){
                List<Integer> fl = new ArrayList<Integer>();
                fl.add(candidates[i]);
                li.add(fl);
                continue;
            }
            
            List<List<Integer>> sub = combinationSum(candidates,nt);
            
            if(!sub.isEmpty()){
                System.out.println(nt+"::"+sub);
                for(List<Integer> comb:sub){
                    int k=0;// just for ordering combo , usefull for comparison
                    while(comb.size()>k && comb.get(k)<candidates[i]  ){
                        k++;
                    }
                    comb.add(k,candidates[i]);
                    
                    if(!contains(li,comb))
                    li.add(comb);
                }
                
            }
        }
        System.out.println(li);
        return li;
    }
    
    private boolean contains(List<List<Integer>> li, List<Integer> comb){
        for(List<Integer> ol:li){
           if(ol.size()!=comb.size()){
                continue;
           }
           boolean c =true;
           for(int i=0;i<comb.size();i++){
               if(ol.get(i)!=comb.get(i)){
                  c =false;
                  break;
               }
           }
           if(c){
              return c; 
           }
        }
       return false;
    }
}
