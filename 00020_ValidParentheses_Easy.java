/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
  Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
Example 4:
Input: s = "([)]"
Output: false
Example 5:
Input: s = "{[]}"
Output: true
  Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.*/
 
class Solution {
    public boolean isValid(String s1) {
        
        Stack<Character> s = new Stack<Character>();
        char[] a=s1.toCharArray();
        
        for(int i=0;i<a.length;i++){
            if(a[i]=='[' || a[i]=='{' ||a[i]=='('){
                s.push(a[i]);
            }else if(!s.isEmpty()){
                char c = s.peek();
                if(a[i]==']' && c=='['){
                    s.pop();
                }else if(a[i]=='}' && c=='{'){
                    s.pop();
                }else if(a[i]==')' && c=='('){
                    s.pop();
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        
        return s.isEmpty();
    }
}
