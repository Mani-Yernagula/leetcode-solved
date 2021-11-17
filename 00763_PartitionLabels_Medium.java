/*You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
Return a list of integers representing the size of these parts.
  Example 1:
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:
Input: s = "eccbbbbdec"
Output: [10]
  Constraints:
1 <= s.length <= 500
s consists of lowercase English letters.*/
 
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> li =new ArrayList<Integer>();
        char[] a = s.toCharArray();
        
        int max = 0;
        int ind = s.lastIndexOf(a[0]);
        max = Math.max(max,ind);
        int i=0;
        int m=0;
        while(i<=max){
            m++;
            if(i==max){
                li.add(m);
                m=0;
                if(i+1<=a.length-1){
                    i++;
                    ind = s.lastIndexOf(a[i]);
                    max = Math.max(max,ind);
                }else{
                    break;
                }
            }else{
                ind = s.lastIndexOf(a[i]);
                max = Math.max(max,ind);
                System.out.println(a[i]+" : "+max);
                i++;
            
            }
         }
        
        return li;
        
    }
}
