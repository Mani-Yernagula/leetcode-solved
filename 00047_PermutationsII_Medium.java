/*Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
  Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10*/
 
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute1(nums.clone());
    }
    public List<List<Integer>> permute1(int[] nums) {
        
        //print(nums);
        // print(nums);
        List<List<Integer>> li = new ArrayList<List<Integer>>();
        if(nums.length==1){
            List<Integer> a = new ArrayList<Integer>();
            a.add(nums[0]);
            List<List<Integer>> r = new ArrayList<>();
            r.add(a);
            return r;
        }

        if(nums.length==2){
            List<Integer> a = new ArrayList<Integer>();
            a.add(nums[0]);a.add(nums[1]);
            List<Integer> b = new ArrayList<Integer>();
            b.add(nums[1]);b.add(nums[0]);
            List<List<Integer>> r = new ArrayList<>();
            r.add(a);
             if(!r.contains(b)){ 
              r.add(b);
             }
            return r;
        }
        int temp = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums.length>2){
               List<List<Integer>> li1 = permute1(Arrays.copyOfRange(nums, 1, nums.length));
               Iterator<List<Integer>> itr= li1.iterator();
               while(itr.hasNext()){
                   itr.next().add(0,temp);
               }
               itr= li1.iterator();
               while(itr.hasNext()){
                   List<Integer> k=  itr.next();
                   if(!li.contains(k)){ 
                    //System.out.println(li+"********"+k);
                    li.add(k); 
                  }
               }
              
             if(i+1<nums.length){
               nums[0]=nums[i+1];
               nums[i+1]=temp;
               temp = nums[0];
               System.out.println("********");
               //print(nums);
             }
            }
        }
        return li;
       
    }
}
