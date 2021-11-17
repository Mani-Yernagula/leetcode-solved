/*Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
  Example 1:
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:
Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
  Constraints:
1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.*/
 
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String,List<Integer>> map =new HashMap<String,List<Integer>>();
        
        char[] s1 =s.toCharArray();
        for(int i=0;i<s1.length;i++){
            if(map.containsKey(s1[i]+"")){
                map.get(s1[i]+"").add(i);
            }else{
                List<Integer> li =new ArrayList<Integer>();
                li.add(i);
                map.put(s1[i]+"",li);
            }
        } 
        //System.out.println(map);
        int m=0;
        for(int i=0;i<words.length;i++){
            String word = words[i];
            m++;
            int ix = -1;
            char[] c1 =word.toCharArray();
            for(int j=0;j<c1.length;j++){
                if(!map.containsKey(c1[j]+"") || (ix=bsearch(c1[j]+"",ix,map.get(c1[j]+"")))==-1){
                    m--;
                    break;
                }
                System.out.println(" updated: "+ix);
            }
            //System.out.println("________________________________________________________"+m);
        }
        return m;
    }
    
    // 1 2 4 6 7 8 9
    
    private int bsearch(String s,int ix,List<Integer> li){
        //System.out.println(s+" : "+ix+" : "+li);
        int ret=-1;
        int l = li.size();
        int lw=0,up = l-1;
        int mid = (lw+up)/2;
        //System.out.println(" lw: "+lw + " up : "+up+" mid:"+ mid);
        while(lw<up && up-lw>2){
            if(li.get(mid)==ix){
                lw=mid;
                break;
            }else if(li.get(mid)<ix){
                lw = mid;
                
            }else{
                up = mid;
            }
            mid = (lw+up)/2;
        }
        //System.out.println(" final : "+ix+" : "+lw+" : "+up);
        while(lw<l){
            if(li.get(lw)>ix){
                //System.out.println(" sending : "+li.get(lw)+" : ");
                return li.get(lw);
            }
            lw++;
        }
        
        return ret;
    }

}
