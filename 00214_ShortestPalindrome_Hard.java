/*You are given a string s. You can convert s to a palindrome by adding characters in front of it.
Return the shortest palindrome you can find by performing this transformation.
  Example 1:
Input: s = "aacecaaa"
Output: "aaacecaaa"
Example 2:
Input: s = "abcd"
Output: "dcbabcd"
  Constraints:
0 <= s.length <= 5 * 104
s consists of lowercase English letters only.*/
 
class Solution {
    public String shortestPalindrome(String s) {
        
        
         String strDash = s+"#"+ new StringBuilder(s).reverse().toString();
        int lps = LPS(strDash);
        String ans = new StringBuilder(s.substring(lps)).reverse().toString()+s;
        return ans;
        
    }
    
    public int LPS(String str){
        int[] lps = new int[str.length()];
        int len=0;
        int i=1;
        while(i<str.length()){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len>0){
                    len=lps[len-1];
                    
                }
                else{
                    i++;
                }
            }
        }
        return lps[lps.length-1];
    }
     
    
    
    Queue<String> li =new LinkedList<String>();
    String ret = "";
    public String longestPalindrome(String s) {
        if(s==null || s.equals("")){
            return s;
        }
        char[] a=s.toCharArray();
        ret = a[0]+"";
        
        int i=(a.length-1)/2;
        i++;
        while(i>-1){
           if(ret.length()<a.length){
            to(a,i);
               
           }
           else
           break;
           i--; 
        }
        //System.out.println(ret.length());
        
        //System.out.println(ret.length());   
        //System.out.println("************");
        
        return ret;
    }
    
    void to(char[] a,int e){
        String fi="";
        String se="";
        
        int i = e-1;
        int j = e+1;
        StringBuffer r = new  StringBuffer();
        r.append(a[e]+"");
        boolean zid=false;
        if(e==0)
            zid=true;
        while(i>-1 && j<a.length){
            if(a[i]==a[j]){
                r.insert(0,a[i]);
                r.append(a[j]);
                if(i==0){
                    zid=true;
                }
            }else{
                    break;
            }
            i--;
            j++;
        }
        //System.out.println(r);
        fi=r.toString();
        if(e+1<a.length && a[e] == a[e+1]){
            i = e-1;
            j = e+2;
            StringBuffer r1 = new  StringBuffer();
            r1.append(a[e]);
            r1.append(a[e+1]);
            while(i>-1 && j<a.length){
                if(a[i]==a[j]){
                    r1.insert(0,a[i]);
                    r1.append(a[j]);
                    if(i==0){
                        zid=true;
                    }
                }else{
                    break;
                }
                i--;
                j++;
            }
            se=r1.toString();
          //  System.out.println(r1);
            fi = fi.length()>se.length()?fi:se;
        }
        
        
        if(zid && ret.length()<fi.length()){
            ret = fi;
        }
        //System.out.println(zid+" : "+e+" : "+i+"-------"+ret);
    }
}
