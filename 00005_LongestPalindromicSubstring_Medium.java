/*Given a string s, return the longest palindromic substring in s.
  Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:
Input: s = "cbbd"
Output: "bb"
Example 3:
Input: s = "a"
Output: "a"
Example 4:
Input: s = "ac"
Output: "a"
  Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.*/
 
class Solution {
    Queue<String> li =new LinkedList<String>();
    String ret = "";
    public String longestPalindrome(String s) {
        char[] a=s.toCharArray();
        
        for(int i=0;i<a.length;i++){
          to(a,i);
        }
        //System.out.println("************");
        
        return ret;
    }
    
    void to(char[] a,int e){
        
        int i = e-1;
        int j = e+1;
        String r = a[e]+"";
        while(i>-1 && j<a.length){
            if(a[i]==a[j]){
                r = a[i]+r+a[j];
            }else{
                    break;
            }
            i--;
            j++;
        }
        //System.out.println(r);
        
        if(e+1<a.length && a[e] == a[e+1]){
            i = e-1;
            j = e+2;
            String r1 = a[e]+""+a[e+1]+"";
            while(i>-1 && j<a.length){
                if(a[i]==a[j]){
                    r1 = a[i]+r1+a[j];
                }else{
                    break;
                }
                i--;
                j++;
            }
          //  System.out.println(r1);
            r = r.length()>r1.length()?r:r1;
        }
        
        
        if(ret.length()<r.length()){
            ret = r;
        }
        //System.out.println("-------"+ret);
    }
    
}
