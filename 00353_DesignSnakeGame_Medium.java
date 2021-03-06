/*Design a Snake game that is played on a device with screen size height x width. Play the game online if you are not familiar with the game.
The snake is initially positioned at the top left corner (0, 0) with a length of 1 unit.
You are given an array food where food[i] = (ri, ci) is the row and column position of a piece of food that the snake can eat. When a snake eats a piece of food, its length and the game's score both increase by 1.
Each piece of food appears one by one on the screen, meaning the second piece of food will not appear until the snake eats the first piece of food.
When a piece of food appears on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
The game is over if the snake goes out of bounds (hits a wall) or if its head occupies a space that its body occupies after moving (i.e. a snake of length 4 cannot run into itself).
Implement the SnakeGame class:
SnakeGame(int width, int height, int[][] food) Initializes the object with a screen of size height x width and the positions of the food.
int move(String direction) Returns the score of the game after applying one direction move by the snake. If the game is over, return -1.
  Example 1:
Input
["SnakeGame", "move", "move", "move", "move", "move", "move"]
[[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
Output
[null, 0, 0, 1, 1, 2, -1]

Explanation
SnakeGame snakeGame = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
snakeGame.move("R"); // return 0
snakeGame.move("D"); // return 0
snakeGame.move("R"); // return 1, snake eats the first piece of food. The second piece of food appears at (0, 1).
snakeGame.move("U"); // return 1
snakeGame.move("L"); // return 2, snake eats the second food. No more food appears.
snakeGame.move("U"); // return -1, game over because snake collides with border
  Constraints:
1 <= width, height <= 104
1 <= food.length <= 50
food[i].length == 2
0 <= ri < height
0 <= ci < width
direction.length == 1
direction is 'U', 'D', 'L', or 'R'.
At most 104 calls will be made to move.*/
 
class SnakeGame {

    int[][] food=null;
    int fs=0;
    int width=0,height=0;
    int[] fl=null;
    
    //int i=0,j=0;
    List<int[]> sn=new ArrayList<int[]>(); 
    //int[][] sn=new int[width][height];
    int fi=0;
    public SnakeGame(int width, int height, int[][] food) {
        this.width=width;
        this.height=height;
        this.food=food;
        fl  =food[fi];
        fi++;
        sn.add(new int[]{0,0});
    }
    
    int[] getDir(String direction,int i,int j){
        if(direction.equals("U")){
            i=i-1;
        }else if(direction.equals("D")){
            i=i+1;
        }else if(direction.equals("L")){
            j=j-1;
        }else if(direction.equals("R")){
            j=j+1;
        }
        return new int[]{i,j};
    }
    
    void p(){
       /* for(int[] r:b){
            System.out.print(" | ");
            for(int c:r){
                System.out.print(c+" | ");
            }
            System.out.println("");
        }
        System.out.println("--------------");*/
    }
    
    boolean inSn(int i,int j){
        for(int[] b:sn){
            if(b[0]==i && b[1]==j){
                return true;
            }
        }
        return false;
    }
    
    public int move(String direction) {
        int[] head= new int[2];
        int[] tail= new int[2];    
        int[] next = getDir(direction,sn.get(0)[0],sn.get(0)[1]);
        int i= next[0];
        int j= next[1];
    //    System.out.println(i+" dir "+j);
        if(i<0 || i>=height || j<0 || j>=width){
             System.out.println("wall");
          //  p();
            return -1;
        }
        head = sn.get(0);
        if(fl[0]==i && fl[1]==j){
            fs++;
            sn.add(0,new int[]{i,j});
            if(fi<food.length){
                fl  =food[fi];
                fi++;
            }else{
                fl = new int[]{-1,-1};
            }
        }else if(inSn(i,j)){
            tail = sn.get(sn.size()-1);
            if(tail[0]!=i || tail[1]!=j){
                System.out.println("body");
               // p();
                return -1;
            }else{
                sn.add(0,new int[]{i,j});
                tail = sn.remove(sn.size()-1);
                //b[tail[0]][tail[1]]=0;
            }
        }else{
            sn.add(0,new int[]{i,j});
            tail = sn.remove(sn.size()-1);
        }
        //p();
        return fs;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
