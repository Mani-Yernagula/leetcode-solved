/*Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.
  Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]
  Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.*/
 
class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>>  res = new ArrayList<List<String>>();
        List<String> li =new ArrayList<String>();
        for(int i=0;i<s.length();i++) {
            li.add(s.charAt(i)+"");
        }
        res.add(li);
        part(li,0,res);
        return res;
    }
    
    Map<String,Boolean>  map  = new HashMap<String,Boolean>();
    
    void part(List<String> parts,int ind,List<List<String>> res) {
        for(int i=ind;i<parts.size();i++) {
            if(i+1<parts.size()) {
                parts.set(i+1,parts.get(i)+parts.get(i+1));
                String x = parts.remove(i);
                boolean pali=true;
                for(int j=0;j<=i;j++) {
                    String tok = parts.get(j);
                    if(!map.containsKey(tok)) {
                        map.put(tok, isPali(tok));
                    }
                    pali &= map.get(tok);
                    if(!pali)
                        break;
                }
                if(pali) {
                    List<String> li =new ArrayList<String>();
                    li.addAll(parts);
                    res.add(li);
                }
                part(parts,i,res);
                parts.set(i,parts.get(i).substring(x.length()));
                parts.add(i,x);
            }
        }
    }
    
    boolean isPali(String s) {
        int i=0;
        if(s.length()%2!=0) {
            i=1;
        }
        String x = s.substring(0,s.length()/2);
        String y = s.substring((s.length()/2)+i);
        return x.equals(new StringBuffer(y).reverse().toString());
    }
    
}
