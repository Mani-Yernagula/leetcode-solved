/*Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.
  Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
  Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.*/
 
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         Map<Character,Integer> map=new HashMap<Character,Integer>();
        char[] a=ransomNote.toCharArray();
        for(char x:a){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else{
                map.put(x,1);
            }
        }
        
        char[] b=magazine.toCharArray();
        for(char x:b){
            if(map.containsKey(x)){
                int y = map.get(x)-1;
                if(y==0)
                map.remove(x);
                else
                map.put(x,y);
            }
        }
        return map.isEmpty();
    }
}
