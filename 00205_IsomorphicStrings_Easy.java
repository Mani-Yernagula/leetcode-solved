/*Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
  Example 1:
Input: s = "egg", t = "add"
Output: true
Example 2:
Input: s = "foo", t = "bar"
Output: false
Example 3:
Input: s = "paper", t = "title"
Output: true
  Constraints:
1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.*/
 
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map= new HashMap<Character,Character>();
        if(s.length()!=t.length()){
            return false;
        }
        System.out.println("----");
        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();
        for(int i=0;i<a1.length;i++){
            if(map.containsKey(a1[i])){
                System.out.println(map.get(a1[i])+" : "+a2[i]);
                char te = map.get(a1[i]);
                if(te!=a2[i]){
                    return false;
                }
            }else if(map.containsValue(a2[i])){
                return false;
            }else{
                map.put(a1[i],a2[i]);   
            }
        }
        return true;
    }
}
