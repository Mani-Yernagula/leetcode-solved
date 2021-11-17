/*Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
  Example 1:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:
Input: s = "abcd", k = 2
Output: "bacd"
  Constraints:
1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104*/
 
class Solution {
    public String reverseStr(String s, int k) {
        char[] a=s.toCharArray();
        int l=a.length;
        int i=0;
        int j = i+k-1;
        
        while(j<l){
            rev(a,i,j);
            i+=2*k;
            j=i+k-1;
        }
        if(i<l)
            rev(a,i,l-1);
        return new String(a);
    }
    
    void rev(char[] a,int i,int j){
        
        while(i<j){
            char t = a[i];
            a[i]=a[j];
            a[j]=t;
            i++;
            j--;
        }
    }
}
