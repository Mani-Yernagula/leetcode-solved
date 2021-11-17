/*Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
  Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
  Constraints:
1 <= words.length <= 500
1 <= words[i] <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
  Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?*/
 
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       Map<String,Integer> m = new HashMap<String,Integer>();
       TreeMap<Integer,String> sm = new TreeMap<Integer,String>(Collections.reverseOrder());
        
       for(String s:words){
           if(m.containsKey(s)){
               int co =m.get(s);
               m.put(s,co+1);
           }else{
               m.put(s,1);
           }
       } 
        
       Iterator itr = m.keySet().iterator();
       //System.out.println(m);
        List<Map.Entry> li =new ArrayList<Map.Entry>();
        // Traverse map and print elements
       for(Map.Entry<String,Integer> en:m.entrySet()) {
           li.add(en);
       } 
        Collections.sort(li,new Comparator<Map.Entry>(){
            public int compare(Map.Entry en1,Map.Entry en2){
                if(((int)en2.getValue())-((int)en1.getValue())==0)
                    return (((String)en1.getKey()).compareTo((String)en2.getKey()));
                return ((int)en2.getValue())-((int)en1.getValue());
            }
        });
        
        List<String> li1 =new ArrayList<String>();
        int i=0;
        int pr=0;
        String ps="";
        while(i<k){
            Map.Entry<String,Integer> en = (Map.Entry<String,Integer>)li.get(i);
                li1.add(en.getKey());
            
            i++;
        }
        
        //Collections.sort(li1);
        return li1;
    } 
}
