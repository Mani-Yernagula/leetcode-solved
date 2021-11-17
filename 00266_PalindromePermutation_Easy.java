/*Given a string s, return true if a permutation of the string could form a palindrome.
  Example 1:
Input: s = "code"
Output: false
Example 2:
Input: s = "aab"
Output: true
Example 3:
Input: s = "carerac"
Output: true
  Constraints:
1 <= s.length <= 5000
s consists of only lowercase English letters.*/
 
class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] a =s.toCharArray();
        Map<Character,Integer> m =new HashMap<Character,Integer>();
        
        for(char c:a){
            int l=1;
            if(m.containsKey(c)){
                l+=m.get(c);
            }
            m.put(c,l);
        }
        
         boolean one=a.length%2==0;
             for(int i:m.values()){
                if(i%2!=0){
                    if(!one)
                        one=!one;
                    else
                        return false;
                }
                    
            }
        return true;
    }
}
