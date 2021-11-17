/*You are playing a Flip Game with your friend.
You are given a string currentState that contains only '+' and '-'. You and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move, and therefore the other person will be the winner.
Return true if the starting player can guarantee a win, and false otherwise.
  Example 1:
Input: currentState = "++++"
Output: true
Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
Example 2:
Input: currentState = "+"
Output: false
  Constraints:
1 <= currentState.length <= 60
currentState[i] is either '+' or '-'.
  Follow up: Derive your algorithm's runtime complexity.*/
 
class Solution {
    
    HashMap<String,Boolean> m = new HashMap<String,Boolean>();
    HashMap<String,List<String>> m1 = new HashMap<String,List<String>>();
    
    public boolean canWin(String currentState) {
        if(m.containsKey(currentState)){
            return m.get(currentState);
        }
        List<String> moves = generatePossibleNextMoves(currentState);
        if(moves.size()==0)
            return false;
        boolean win=false;
        for(String move:moves){
            win = canWin(move);
            m.put(move,win);
            if(!win){
                return true;
            }
        }
        return false;
    }
    
    
    
    public List<String> generatePossibleNextMoves(String currentState) {
        if(m1.containsKey(currentState)){
            return m1.get(currentState);
        }
        char[] a=currentState.toCharArray();
        List<String>  ret = new ArrayList<String>();
        for(int i=1;i<a.length;i++){
            if(a[i-1]=='+' && a[i]=='+'){
                a[i-1]='-';
                a[i]='-';
                ret.add(new String(a));
                a[i]='+';
                a[i-1]='+';
            }
        }
        m1.put(currentState,ret);
        return ret;
    }
}
