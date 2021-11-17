/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.
  Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
  Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
  Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?*/
 
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        char[] a=s.toCharArray();
        for(char x:a){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else{
                map.put(x,1);
            }
        }
        
        char[] b=t.toCharArray();
        for(char x:b){
            if(map.containsKey(x)){
                int y = map.get(x)-1;
                if(y==0)
                map.remove(x);
                else
                map.put(x,y);
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
}
