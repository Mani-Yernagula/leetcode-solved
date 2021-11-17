/*Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
  Example 1:
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: c = 3
Output: false
Example 3:
Input: c = 4
Output: true
Example 4:
Input: c = 2
Output: true
Example 5:
Input: c = 1
Output: true
  Constraints:
0 <= c <= 231 - 1*/
 
class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==0){
            return true;
        }
        int x =  (int)Math.sqrt(c);
        int i=-1;
        //System.out.println("----"+x+" : "+y);
        int y=(x/2);
        while(i<y){
            int k = c-(x*x);
            //System.out.println(k+" : "+i);
            if(checkPerfectSquare(k)){
                return true;
            }
            x--;
            i++;
        }
        return false;
    }
    boolean checkPerfectSquare(double x){ 
        double sq = Math.sqrt(x); 
        return ((sq - Math.floor(sq)) == 0); 
    } 
}
