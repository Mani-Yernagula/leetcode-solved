/*You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
  Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:
Input: s = "azxxzy"
Output: "ay"
  Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.*/
 
class Solution {
    public String removeDuplicates(String str) {
        Stack<Character> s =new Stack<Character>();
        char[] a = str.toCharArray();
        s.push(a[0]);
        for(int i=1;i<a.length;i++){
           if(!s.isEmpty()){
               char c =s.peek();
               if(c == a[i]){
                   s.pop();
               }else{
                   s.push(a[i]);
               }
           }else{
               s.push(a[i]); 
           }
           //System.out.println(s);
        }
        
        StringBuilder sb = new StringBuilder();
  
        // Appends characters one by one
        for (Character ch : s) {
            sb.append(ch);
        }
  
        // convert in string
        return sb.toString();
    }
    
    
 
  
}
