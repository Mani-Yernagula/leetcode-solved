/*You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
  Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
  Constraints:
1 <= s.length <= 105
2 <= k <= 104
s only contains lower case English letters.*/
 
class Solution {
    class Pair{
        char c;
        int count;
        public Pair(char c,int count){
            this.c=c;
            this.count=count;
        }
        public String toString(){
            return c +" - "+count;
        }
    }
    
    public String removeDuplicates(String str, int k) {
            Stack<Pair> s =new Stack<Pair>();
            char[] a = str.toCharArray();
            s.push(new Pair(a[0],1));
            for(int i=1;i<a.length;i++){
               if(!s.isEmpty()){
                   Pair p =s.peek();
                    if(p.c == a[i]){
                       if(p.count+1==k){
                           s.pop();
                       }else{
                           p.count = p.count+1;
                       }
                   }else{
                       s.push(new Pair(a[i],1));
                   }
               }else{
                       s.push(new Pair(a[i],1));
               }
              // System.out.println(s);
            }

            StringBuilder sb = new StringBuilder();

            // Appends characters one by one
            for (Pair ch : s) {
                while(ch.count-->0)
                sb.append(ch.c);
            }
        System.out.println("------------------");
            // convert in string
            return sb.toString();
        }
    
}
