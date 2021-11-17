/*You are playing the following Nim Game with your friend:
Initially, there is a heap of stones on the table.
You and your friend will alternate taking turns, and you go first.
On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
The one who removes the last stone is the winner.
Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend play optimally, otherwise return false.
  Example 1:
Input: n = 4
Output: false
Explanation: These are the possible outcomes:
1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
In all outcomes, your friend wins.
Example 2:
Input: n = 1
Output: true
Example 3:
Input: n = 2
Output: true
  Constraints:
1 <= n <= 231 - 1*/
 
class Solution {
    
     public boolean canWinNim(int n) {
         return n%4!=0;
    }
   
    Map<Integer,Boolean> m = new HashMap<Integer,Boolean>();
    public boolean canWinNimGood(int n) {
        int k= 4*4*4*4*4*4*4*4;
        //System.out.println(k);
        while(n>k){
            n=n-k;
        }
        //System.out.println(":::"+n);
     
        return canWinNimU(n);
    }
        
    public boolean canWinNimU(int n) {
        if(m.containsKey(n)){
            return m.get(n);
        }
        if(n>0 && n<=3){
            return true;
        }
        int i=1;
        boolean win =false; 
        while(i<4){
            win =canWinNimU(n-i);
            m.put(n-i,win);
            if(!win){
                return true;
            }      
            i++;
        } 
        return false;
    }
}
