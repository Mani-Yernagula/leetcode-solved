/*You are given two strings order and s. All the words of order are unique and were sorted in some custom order previously.
Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
Return any permutation of s that satisfies this property.
  Example 1:
Input: order = "cba", s = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
Example 2:
Input: order = "cbafg", s = "abcd"
Output: "cbad"
  Constraints:
1 <= order.length <= 26
1 <= s.length <= 200
order and s consist of lowercase English letters.
All the characters of order are unique.*/
 
class Solution {
    public String customSortString(String order, String str) {
        
        
        
        char[]a = str.toCharArray();
        List<Character> li=new ArrayList<Character>();
        for(int i=0;i<a.length;i++){
            if(order.indexOf(a[i])!=-1){
                addEle(a[i],li,order);
                a[i]='0';
            }
        }
        //System.out.println(li);
        for(int i=0;i<a.length;i++){
            if(a[i]=='0'){
                a[i]=li.remove(0);
            }
        }
        String s =new String(a);
        //System.out.println("---------------"+s);
        return s;
    }
    
    private void addEle(Character c ,List<Character> li,String order){
        if(li.size()<1){
            li.add(c);
            return;
        }
        int l=0,r=li.size()-1;
        int mid  = (l+r)/2;
        while(l<r){
            if(li.get(mid)==c){
                li.add(mid,c);
                return;
            }
            if(order.indexOf(li.get(mid))<order.indexOf(c)){
                l = mid+1;
            }else{
                r = mid-1;
            }
            mid  = (l+r)/2;
        }
        //System.out.println("**"+li+" : "+mid);
        if(order.indexOf(li.get(mid))>order.indexOf(c))
        li.add(mid,c);
        else
        li.add(mid+1,c);
    }
}
