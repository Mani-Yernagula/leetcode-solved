/*Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
  Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
  Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.*/
 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i=0;i<wordDict.size();i++){
           // System.out.println(s+"::"+i);
           // System.out.println(wordDict);
            int j=0;
            if(s.startsWith(wordDict.get(i))){
                if(s.length()==wordDict.get(i).length()){
                    return true;
                }
                j=wordDict.get(i).length();
                while(s.substring(j).startsWith(wordDict.get(i))) {
                    if(s.substring(j).length()==wordDict.get(i).length()){
                        return true;
                    }
                    j+=wordDict.get(i).length();
                }
                if(j>0 && wordBreak(s.substring(j),wordDict)){
                  return true;
                }
            }
        }
        return false;
    }
}
