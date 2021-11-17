/*Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:
Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
  Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:
  Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.*/
 
class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board,0,0);
    }
    
    public boolean solveSudoku(char[][] b,int i,int j) {
        if(i==9){
           // p(b);
            return true;
        }
        if(b[i][j]!='.'){
            if(j==8){
                if(solveSudoku(b,i+1,0))
                    return true;
            }else{
                if(solveSudoku(b,i,j+1))
                    return true;
            }
        }else{
            for(int k=49;k<58;k++){
                if(canUse(b,i,j,k)){
                    b[i][j]=(char)(k);
                    if(j==8){
                        if(solveSudoku(b,i+1,0))
                            return true;
                    }else{
                        if(solveSudoku(b,i,j+1))
                            return true;
                    }
                    b[i][j]='.';
                }    
            }
            
        }
        return false;
    }
    
    boolean canUse(char[][] b,int i,int j,int v){
        
        for(int k=0;k<9;k++){
            if(b[i][k]==(char)(v))
                return false;
            if(b[k][j]==(char)(v))
                return false;
        }
        
        int i1=3*(i/3);
        int j1=3*(j/3);
        
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(b[i1+k][j1+l]==(char)(v))
                    return false;
            }    
        }
        return true;
    }
    
    void p(char[][] b){
       for(int k=0;k<9;k++){
            for(int l=0;l<9;l++){
                System.out.print(b[k][l]+",");
            } 
           System.out.println("\n");
        } 
    }
    
}
