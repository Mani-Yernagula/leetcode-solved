/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
  Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]
  Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.*/
 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
    
    boolean areAnagrams(String x,String y){
        char[] a=x.toCharArray();
        char[] b=y.toCharArray();
        if(a.length!=b.length){
            return false;
        }
        int t=0,i=0,k=0;
        List<Integer> li1 =new ArrayList<Integer>(Collections.nCopies(26, 0));
        while(k<a.length){
            int m=a[k]-'a';
            Integer n = li1.get(m);
            li1.set(m,n+1);
            m=b[k]-'a';
            n = li1.get(m);
            li1.set(m,n-1);
            k++;    
        }
        
        k=0;
        while(k<li1.size()){
            if(li1.get(k)!=0){
                return false;
            }
            k++;    
        }
        
        return true;
    }
}
