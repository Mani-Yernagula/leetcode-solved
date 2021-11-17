/*Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
Machine 1 (sender) has the function:
string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:
string encoded_string = encode(strs);
and Machine 2 does:
vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.
Implement the encode and decode methods.
You are not allowed to solve the problem using any serialize methods (such as eval).
  Example 1:
Input: dummy_input = ["Hello","World"]
Output: ["Hello","World"]
Explanation:
Machine 1:
Codec encoder = new Codec();
String msg = encoder.encode(strs);
Machine 1 ---msg---> Machine 2

Machine 2:
Codec decoder = new Codec();
String[] strs = decoder.decode(msg);
Example 2:
Input: dummy_input = [""]
Output: [""]
  Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] contains any possible characters out of 256 valid ASCII characters.
  Follow up: Could you write a generalized algorithm to work on any possible set of characters?*/
 
public class Codec {

    int code= 50;
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String x:strs){
            if(x.equals("")){
                sb.append((char)300);
                sb.append((char)301);
                continue;
            }
            char[] cs=x.toCharArray();
            for(int i=0;i<cs.length;i++){
                cs[i] = (char) ((int)cs[i]+code);
            }
            sb.append(new String(cs));
            sb.append((char)301);
        }
        System.out.println(">>>>"+sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> li  =new ArrayList<String>();
        
            char[] cs=s.toCharArray();
            StringBuffer tok = new StringBuffer();
            for(int i=0;i<cs.length;i++){
                if((int)cs[i]==300){
                    li.add(new String(""));        
                }else if((int)cs[i]==301){
                    if(!tok.toString().equals(""))
                    li.add(tok.toString()); 
                    tok = new StringBuffer();
                }else{
                    tok.append((char)((int)cs[i]-code));    
                }
            }
        return li;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
