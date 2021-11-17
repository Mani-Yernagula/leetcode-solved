/*Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
Given a balanced string s, split it in the maximum amount of balanced strings.
Return the maximum amount of split balanced strings.
  Example 1:
Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:
Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:
Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
Example 4:
Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
  Constraints:
1 <= s.length <= 1000
s[i] is either 'L' or 'R'.
s is a balanced string.*/
 
class Solution {
    public int balancedStringSplit(String s) {
        Stack<Character> st =new Stack<Character>();
        char[] ch = s.toCharArray();
        st.push(ch[0]);
        int co=1;
        int ret=0;
        for(int i=1;i<ch.length;i++){
            if(!st.isEmpty() && !st.peek().equals(ch[i])){
                st.pop();
                co--;
            }else{
                st.push(ch[i]);
                co++;
            }
            if(co==0){
                ret++;
            }
        }
        return ret;
        
    }
}
