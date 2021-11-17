/*Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
  Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
  Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
  Follow up: Could you use search pruning to make your solution faster with a larger board?*/
 
class Solution {
    class Index{
        int r=0;
        int c=0;
        public Index(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public boolean exist(char[][] b, String word) {
        char[] w = word.toCharArray();
        int r=b.length;
        int c=b[0].length;
        int ind=0;
        Set<String> s= new HashSet<String>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(w[0]==b[i][j]){
                   s.clear();
                   s.add(i+","+j);
                   if(dfs(b,i,j,w,ind+1,s)){
                       return true;
                   }
                }
            }    
        }
        return false;
    }
    
    boolean dfs(char[][] b,int i,int j,char[] w,int ind,Set<String> vi){
        //System.out.println("IP "+ind+" "+vi);
        if(ind==w.length){
            //System.out.println(vi);
            return true;
        }
        int r=b.length;
        int c=b[0].length;
        
        List<Index> li=new ArrayList<Index>();
        
        if(i-1>-1 && b[i-1][j]==w[ind])li.add(new Index(i-1,j));
        if(i+1<r  && b[i+1][j]==w[ind])li.add(new Index(i+1,j));
        if(j-1>-1 && b[i][j-1]==w[ind])li.add(new Index(i,j-1));
        if(j+1<c  && b[i][j+1]==w[ind])li.add(new Index(i,j+1));
        
        for(Index ni:li){
            if(!vi.contains(ni.r+","+ni.c)){
                vi.add(ni.r+","+ni.c);
                if(dfs(b,ni.r,ni.c,w,ind+1,vi)){
                    return true;
                }
                vi.remove(ni.r+","+ni.c);
            }
        }
        return false;
    }
}
