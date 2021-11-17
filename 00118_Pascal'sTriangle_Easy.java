/*Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
  Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:
Input: numRows = 1
Output: [[1]]
  Constraints:
1 <= numRows <= 30*/
 
class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> o = new ArrayList<Integer>();
        o.add(1);
        ret.add(o);
        
        for(int i=1;i<numRows;i++){
            o=generate(o);
            ret.add(o);    
        }
        return ret;
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
