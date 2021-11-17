/*A message containing letters from A-Z can be encoded into numbers using the following mapping:
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
In addition to the mapping above, an encoded message may contain the '*' character, which can represent any digit from '1' to '9' ('0' is excluded). For example, the encoded message "1*" may represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19". Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.
Given a string s consisting of digits and '*' characters, return the number of ways to decode it.
Since the answer may be very large, return it modulo 109 + 7.
  Example 1:
Input: s = "*"
Output: 9
Explanation: The encoded message can represent any of the encoded messages "1", "2", "3", "4", "5", "6", "7", "8", or "9".
Each of these can be decoded to the strings "A", "B", "C", "D", "E", "F", "G", "H", and "I" respectively.
Hence, there are a total of 9 ways to decode "*".
Example 2:
Input: s = "1*"
Output: 18
Explanation: The encoded message can represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19".
Each of these encoded messages have 2 ways to be decoded (e.g. "11" can be decoded to "AA" or "K").
Hence, there are a total of 9 * 2 = 18 ways to decode "1*".
Example 3:
Input: s = "2*"
Output: 15
Explanation: The encoded message can represent any of the encoded messages "21", "22", "23", "24", "25", "26", "27", "28", or "29".
"21", "22", "23", "24", "25", and "26" have 2 ways of being decoded, but "27", "28", and "29" only have 1 way.
Hence, there are a total of (6 * 2) + (3 * 1) = 12 + 3 = 15 ways to decode "2*".
  Constraints:
1 <= s.length <= 105
s[i] is a digit or '*'.*/
 
class Solution {
     final int MOD = 1000000007;
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // State & Initialize
        int len = s.length();
        long[] dp = new long[len + 1];  // we should use long array here to avoid overfolw Integer
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) != '0' ? 1 : 0;
        
        // Function
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) == '*') {
                dp[i] = 9 * dp[i - 1] % MOD;
                if (s.charAt(i - 2) == '1') {
                    dp[i] = (dp[i] + 9 * dp[i - 2]) % MOD;
                } else if (s.charAt(i - 2) == '2') {
                    dp[i] = (dp[i] + 6 * dp[i - 2]) % MOD;
                } else if (s.charAt(i- 2) == '*') {
                    dp[i] = (dp[i] + 15 * dp[i - 2]) % MOD;
                }
            } else {
                // if s.charAt(i-1) != '*' && s.charAt(i-1) != '0', => s[i-1] could be decode as a character.
                // then dp[i] = dp[i-1]
                // if s.charAt(i-1) == '0', => s[i-1] couldn't be decoded as a character
                // it means it can't make any contributions to the result, so dp[i] = 0
                dp[i] = s.charAt(i - 1) != '0' ? dp[i - 1] : 0;  
                if (s.charAt(i - 2) == '1') {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                } else if (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                } else if (s.charAt(i - 2) == '*') {
                    dp[i] = (dp[i] + ((s.charAt(i - 1) <= '6' ? 2 : 1) * dp[i - 2])% MOD) % MOD;
                }
            }
        }
        
        return (int)dp[len];
    }
    
    
    public int numDecodings3(String s) {
        
        char c = s.charAt(0);
        int x = (int)c;
        if(x!=42)
            x = x-48;
        
        if(x==0){
            return 0;
        }
        
        if(s.length()==1){
            return 1;
        }
        //System.out.println(x);
        System.out.println(s);
        int j=0,z=1;
        if(x==1 || x==2){
            while(++j<s.length()){
                //System.out.println("++j : "+j);
                if((x!=1 && x!=2)){
                    if(x>6){
                        j--;
                    }
                    break;
                }
                x =(int) s.charAt(j);
                x = x-48;
            }
            System.out.println("j : "+j);
            //j = j==s.length()?s.length()-1:j;
            z = numDecodings1(s.substring(0,j));
            System.out.println("z : "+z);
        }else{
            j=1;
            z=1;
        }
        if(s.length()>j){
                int nl =(int) s.charAt(j);
                System.out.println("j2 : "+s.charAt(j)+":"+(j)+" : "+nl);
                nl = nl-48;
                if(nl==0 && (x!=1 || x!=2)){
                    return 0;
                }else if(nl==-6){
                    j++;
                }
                return numDecodings(s.substring(j))*z;
        }
        return z;
    }
    
    public int numDecodings1(String s) {
        System.out.println("1s2s : "+s);
        if(s.endsWith("10") || s.endsWith("20")){
             return s.length()>2? numDecodings1(s.substring(0,s.length()-2)):1;
        }
        if(s.endsWith("*")){
            if(s.length()>1){
                int w =(int)s.charAt(s.length()-2);
                w = w-48;
                if(w!=1 && w!=2){
                    return numDecodings1(s.substring(0,s.length()-2))+9;
                }else if(w==1 || w==2){
                    return (numDecodings1(s.substring(0,s.length()-1)+"1")*6) + numDecodings1(s.substring(0,s.length()-1))*3;
                }
            }
            return 9;
        }
        if(s.length()==1 || s.length()==2){
            return s.length();
        }else{
           return (numDecodings1(s.substring(2))) + (numDecodings1(s.substring(1)));
        }
    }
}
