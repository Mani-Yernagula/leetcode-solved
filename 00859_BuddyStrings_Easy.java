/*Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
  Example 1:
Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
Example 2:
Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
Example 3:
Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
Example 4:
Input: s = "aaaaaaabc", goal = "aaaaaaacb"
Output: true
  Constraints:
1 <= s.length, goal.length <= 2 * 104
s and goal consist of lowercase letters.*/
 
class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if(s.length()!=goal.length()){
            return false;
        }
        if(s.equals(goal) ){
            Set<Character> set=new HashSet<Character>();
            char[] a=s.toCharArray();
            int i=0;
            while(i<a.length){
                if(set.contains(a[i])){
                    return true;
                }else{
                    set.add(a[i]);
                }
                i++;
            }
            return false;
        }
        
        
        
        char[] a=s.toCharArray();
        char[] b=goal.toCharArray();
        String x = "";
        String y = "";
        
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                x +=a[i]+"";
                y =b[i]+""+y;
            }
        }
        if(x.length()>2){
            return false;
        }
        return x.equals(y);
    }
}
