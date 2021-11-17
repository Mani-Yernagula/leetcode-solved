/*Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
  Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
  Constraints:
1 <= s.length <= 5 * 104
0 <= k <= 50*/
 
class Solution {
    public int lengthOfLongestSubstringKDistinct(String ins, int k) {
        if(k<1){
            return 0;
        }
        Queue<Character> q  =new LinkedList<Character>();
        Set<Character> s  =new HashSet<Character>();
        
        char[] a=ins.toCharArray();
        int ret=1;
        int j=0;
        for(int i=0;i<a.length;i++){
            char c=a[i];
            while(s.size()==k && !s.contains(c)){
                //clear
              char cr =q.remove();
                j++;
              if(!q.contains(cr))
                 s.remove(cr);
            }
            
            q.add(c);
            s.add(c);
            
            
           int t =i-j+1;
           // System.out.println(s+"::"+q+" :: "+t);
           ret = ret<t?t:ret; 
        }
        
        return ret;
    }
}
