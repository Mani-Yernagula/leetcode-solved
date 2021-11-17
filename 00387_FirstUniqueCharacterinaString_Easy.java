/*Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
  Example 1:
Input: s = "leetcode"
Output: 0
Example 2:
Input: s = "loveleetcode"
Output: 2
Example 3:
Input: s = "aabb"
Output: -1
  Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.*/
 
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        char[] a=s.toCharArray();
        int i=0;
        int m=100000;
        for(char x:a){
            if(map.containsKey(x)){
                map.put(x,-1);
            }else{
                map.put(x,i);
            }
            i++;
        }
        //System.out.println(map);
        Iterator<Integer> itr=map.values().iterator();
        while(itr.hasNext()){
            int f = itr.next();
            if(f==-1)continue;
            m=f<m?f:m;
        }
        return m==100000?-1:m;
    }
}
