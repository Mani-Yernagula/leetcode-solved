/*Given a string s, find the length of the longest substring without repeating characters.
  Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:
Input: s = ""
Output: 0
  Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.*/
 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.equals("")){
            return 0;
        }
        char[] a=s.toCharArray();
        int i=0,j=1;
        int max=1;
        while(j<a.length){
            int i1=i;
            while(i1<j){
                if(a[i1]==a[j]){
                    i1++;
                    i=i1;
                    break;
                }
                i1++;    
            }
            max=max<(j-i+1)?(j-i+1):max;
            j++;
        }
        return max;
    }
}
