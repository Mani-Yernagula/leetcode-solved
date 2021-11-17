/*Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
  Example 1:
Input: s = "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"
Example 2:
Input: s = "aeiou"
Output: ""
  Constraints:
1 <= s.length <= 1000
s consists of only lowercase English letters.*/
 
class Solution {
    public String removeVowels(String s) {
        char[] a=s.toCharArray();
        StringBuffer sb =new StringBuffer();
        Set<Integer> set = new HashSet<Integer>();
        set.add((int)'a');
        set.add((int)'e');
        set.add((int)'i');
        set.add((int)'o');
        set.add((int)'u');
        
        for(char x:a){
            int y =(int)x;
            if(!set.contains(y))
            sb.append(x);
        }
        return sb.toString();
    }
}
