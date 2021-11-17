/*Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
  Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
  Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10*/
 
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> intList = new ArrayList<Integer>(nums.length);
        for (int i : nums){
            intList.add(i);
        }
        List<Integer> li =new ArrayList<Integer>();
        List<List<Integer>> zz =new ArrayList<List<Integer>>();
        zz.add(li);
        if(intList.size()>0){
            
            zz.addAll(subsetsWithDup(intList));
        }
       return zz;
    }
    
     public List<List<Integer>> subsetsWithDup(List<Integer> nums) {
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        if(nums.size()==2){
            List<Integer> li =new ArrayList<Integer>();
            li.add(nums.get(0));
            temp.add(li);
            temp.add(nums);
            if(nums.get(0)!=nums.get(1)){
                List<Integer> li1 =new ArrayList<Integer>();
                li1.add(nums.get(1));
                temp.add(li1);
            }
            return temp;
        }
         if(nums.size()==1){
            temp.add(nums);
             return temp;
         }
        List<Integer> sub =new ArrayList<Integer>();
        sub.addAll(nums);
        int k = sub.remove(0);
        temp= subsetsWithDup(sub);
        List<Integer> li =new ArrayList<Integer>();
        li.add(k);
        List<List<Integer>> temp1 = new ArrayList<List<Integer>>();
        for(List<Integer> s:temp){
            List<Integer> t =new ArrayList<Integer>();
            t.addAll(s);
            t.add(0,k);
            if(!con(temp,t))
            temp1.add(t);
        }
        temp.addAll(temp1);
         if(!con(temp,li))
        temp.add(li); 
        return temp;
    }
    
    boolean con(List<List<Integer>> fin,List<Integer> t){
         boolean ret =false;
        for(List<Integer> s:fin){
            if(s.size()==t.size()){
                int i=0;
                for(;i<s.size();i++){
                    //for(int j=0;j<t.size();j++){
                        if(s.get(i)!=t.get(i)){
                            break;
                        }
                    //}
                }
                if(i==s.size()){
                    return true;
                }
            }
        }
        return ret;
    }
}
