/*Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
  Example 1:
Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:
Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:
Input: num1 = "0", num2 = "0"
Output: "0"
  Constraints:
1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.*/
 
class Solution {
    public String addStrings(String num1, String num2) {
        char[] a1=num1.toCharArray();
        char[] a2=num2.toCharArray();
        
        int n =Math.max(a1.length,a2.length);
        String ret="";
        int rem=0;
        for(int i=0;i<n;i++){
            int k=0;
            k += (a1.length-1)-i>-1?Integer.parseInt(a1[(a1.length-1)-i]+""):0;
            k += (a2.length-1)-i>-1?Integer.parseInt(a2[(a2.length-1)-i]+""):0;
            k += rem;
            ret= (k%10) + ret;
            rem=k/10;
        }
        if(rem!=0)
            ret = rem+ret;
        return ret;
    }
}
