/*Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
  Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:
Input: triangle = [[-10]]
Output: -10
  Constraints:
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
  Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?*/
 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> f = triangle.get(0);
        for(int i=1;i<triangle.size();i++){
           f= minimumTotal(f,triangle.get(i),i+1==triangle.size());
           //System.out.println(f);
        }
        
        return f.get(f.size()-1);
    }
    
    public List<Integer> minimumTotal(List<Integer> pr,List<Integer> lin,boolean l) {
        int min= 20000;
       // System.out.println(l);
       // System.out.println(pr);
       // System.out.println(lin);
        List<Integer> la = new ArrayList<Integer>();
        for(int i=0;i<lin.size();i++){
            int m1=20000;
            int m2=20000;
            if(i-1>-1){
                m1 = pr.get(i-1)+lin.get(i);
            }
            if(i<pr.size()){
                m2 = pr.get(i)+lin.get(i);
            }
            int c =Math.min(m1,m2);
            min = min>c?c:min;
            la.add(c);
        }
        if(l){
            //System.out.println(min);
            la.add(min);
        }
        return la;
    }
    
    
}
