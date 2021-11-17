/*Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.
  Example 1:
Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
Example 3: 
Input: n = 5
Output: 68
  Constraints:
1 <= n <= 2 * 10^4*/
 
class Solution {
    
    HashMap<String,Long> map = new HashMap<String,Long>();
    
    int mod= 1000000000 + 7;
    
    public int countVowelPermutation(int n) {
        List<String> a = new ArrayList<String>();
        a.add("a");a.add("e");a.add("i");a.add("o");a.add("u");
        long tot=0;
        for(String c:a){
            tot+=perm(c,a,n-1);
            System.out.println("c "+tot);
        }
        
        System.out.println("c --------------------"+tot +" : "+mod);
        return (int) (tot % mod);
    }
    
    public long perm(String a,List<String> chars,long n){
        long tot = 0;
        
        if(map.containsKey(a+(n))){
            return map.get(a+(n));
        }
        
        if(n==0){
            return 1;
        }
        if(n==1){
            if(a.equals("a")){
                return 1;
            }else if(a.equals("e")){
                return 2;
            }else if(a.equals("i")){
                return 4;
            }else if(a.equals("o")){
                return 2;
            }else if(a.equals("u")){
                return 1;
            }
        }       
        
        if(a.equals("a")){
            tot += perm("e",chars,n-1);
        }else if(a.equals("e")){
            tot += perm("a",chars,n-1) + perm("i",chars,n-1);
        }else if(a.equals("i")){
            tot += perm("a",chars,n-1) + perm("e",chars,n-1) + perm("o",chars,n-1) + perm("u",chars,n-1);
        }else if(a.equals("o")){
            tot += perm("i",chars,n-1) + perm("u",chars,n-1);
        }else if(a.equals("u")){
            tot += perm("a",chars,n-1);
        }
        
        if(!map.containsKey(a+(n))){
            map.put(a+(n),tot % mod);
        }
        
        return tot % mod;
    }
}
