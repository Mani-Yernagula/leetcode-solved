/*Given an integer array nums, handle multiple queries of the following types:
Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:
NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
  Example 1:
Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
  Constraints:
1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange.*/
 
class NumArray {

    ArrayList<Integer> li =new ArrayList<Integer>();
    boolean init=false;
    int tot=0;
    
    public NumArray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            li.add(nums[i]);
        }
        sumRange(0,li.size()-1);
    }
    
    public void update(int index, int val) {
        tot-=li.get(index);
        tot+=val;
        li.set(index,val);
    }
    
    public int sumRange(int left, int right) {
        if(!init){
            for(int i=0;i<li.size();i++){
              tot+=li.get(i);
            }
            init =true;
        }
        int l=0,r=0;
        for(int i=0;i<left;i++){
              l+=li.get(i);
            }
        for(int i=right+1;i<li.size();i++){
              r+=li.get(i);
            }
        return tot-l-r;
    }
}

/**not
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
