/*Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
  Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
  Constraints:
1 <= n <= 104*/
 
class Solution {
    
    HashMap<Integer,Integer> dp = new HashMap<Integer,Integer>();
    
    public int numSquares(int n) {
       //System.out.println("best "+n);
       if(dp.containsKey(n)){
           return dp.get(n);
       }
       if(n==1 || n==2 || n==3){
           return n;
       } 
       int k = new Double(Math.sqrt(n)).intValue();
       if(n-(k*k)==0){
           return 1;
       }
       int min=100000;
       for(int i=2;i<=k;i++){
           int j = 1+numSquares(n-(i*i));
           min = j<min?j:min;
       }
       // System.out.println(n+"::"+min);
       if(!dp.containsKey(n)){
           dp.put(n,min);
       } 
       return  min;
    }
    
   
}
