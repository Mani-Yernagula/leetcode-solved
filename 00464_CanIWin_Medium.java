/*In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player who first causes the running total to reach or exceed 100 wins.
What if we change the game so that players cannot re-use integers?
For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without replacement until they reach a total >= 100.
Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can force a win, otherwise, return false. Assume both players play optimally.
  Example 1:
Input: maxChoosableInteger = 10, desiredTotal = 11
Output: false
Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.
Example 2:
Input: maxChoosableInteger = 10, desiredTotal = 0
Output: true
Example 3:
Input: maxChoosableInteger = 10, desiredTotal = 1
Output: true
  Constraints:
1 <= maxChoosableInteger <= 20
0 <= desiredTotal <= 300*/
 
class Solution {
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        boolean[] used = new boolean[maxChoosableInteger + 1];
        Map<Integer, Boolean> memo = new HashMap<>();
        return canIWin(0, desiredTotal, used, memo);
    }
    
    private boolean canIWin(int sum, int desiredTotal, boolean[] used, Map<Integer, Boolean> memo) {
        if (sum >= desiredTotal) return false;
        int bit = bitMap(used);
        Boolean status = memo.get(bit);
        if (status != null) return status;
        // If the opponent always win or I always lose, then win is false
        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                status = !canIWin(sum + i, desiredTotal, used, memo);
                used[i] = false;
                if (status) break;
            }
        }
        memo.put(bit, status);
        return status;
    }
    
    private int bitMap(boolean[] used) {
        int bit = 0;
        for (boolean v : used) {
            bit <<= 1;
            if (v) {
                bit |= 1;
            }
        }
        return bit;
    }
    
   public boolean canIWin1(int maxChoosableInteger, int desiredTotal) {
       int sum= (maxChoosableInteger*(maxChoosableInteger+1))/2;
       if(sum<desiredTotal)
           return false;
        boolean[] li = new boolean[maxChoosableInteger+1];
        int i = 1;
        while (i <= maxChoosableInteger) {
            li[i]=true;
            i++;
        }
        return  canIWin(0, desiredTotal, li);
    }
    
    Map<String,Boolean> m =new HashMap<String,Boolean>();

        
    private boolean canIWin(int cur, int dt, boolean[] li) {
        int z=set(li);
        if(m.containsKey(""+z)){
            return m.get(""+z);
        }
        
        boolean win = false;
        for (int i = 1; i < li.length; i++) {
            if(li[i])
            if(cur+i >= dt) {
                return true;
            } else {
                li[i]=false;
                cur += i; 
                //int z1=set(li);
                win |= !canIWin(cur, dt, li);
                //m.put(""+z1,!win);
                cur -= i; 
                li[i]=true;
                if (win) {
                    break;
                }
            }
        }
        m.put(""+z,win);
        return win;
    }
    
    int set(boolean[] li) {
        int myByte = 0;
        for(int i=1;i<li.length;i++) {
            if(li[i])
            myByte |= 1 << i;
        }
        return myByte;
    }

    
    
}
