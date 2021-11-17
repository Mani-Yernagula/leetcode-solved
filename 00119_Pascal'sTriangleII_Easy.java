/*Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
  Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:
Input: rowIndex = 0
Output: [1]
Example 3:
Input: rowIndex = 1
Output: [1,1]
  Constraints:
0 <= rowIndex <= 33
  Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?*/
 
class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> o = new ArrayList<Integer>();
        o.add(1);
        
        for(int i=1;i<=rowIndex;i++){
            o=generate(o);
        }
        return o;
    }
    
    List<Integer> generate(List<Integer> p){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        int k=1;
        while(k<p.size()){
            a.add(p.get(k-1)+p.get(k));
            k++;
        }
        a.add(1);
        return a;
    }
}
