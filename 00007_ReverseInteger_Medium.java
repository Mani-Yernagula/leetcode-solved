/*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
  Example 1:
Input: x = 123
Output: 321
Example 2:
Input: x = -123
Output: -321
Example 3:
Input: x = 120
Output: 21
Example 4:
Input: x = 0
Output: 0
  Constraints:
-231 <= x <= 231 - 1*/
 
class Solution {
    public int reverse(int x) {
        
        int k=0;
        int i = x<0?-x:x;
        while(i>0){
            //System.out.println(x);
            int j= (k*10)+(i%10) ;
            System.out.println(j +" : "+k);
            if(k!=0 && j/k<10){
                return 0;
            }else{
                k=j;
            }
            i = i/10;
           // System.out.println(k);
        }
        return x<0?-k:k;
    }
}
