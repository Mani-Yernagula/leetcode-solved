/*You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
Return true if you can make this square and false otherwise.
  Example 1:
Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:
Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
  Constraints:
1 <= matchsticks.length <= 15
1 <= matchsticks[i] <= 108*/
 
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int p=0;
        
        for(int i=0;i<matchsticks.length;i++){
            p+=matchsticks[i];
        }
        if(p%4==0){
           int l = p/4; 
           int[] walls = new int[]{l,l,l,l};
           return fitInWall(matchsticks,walls);
        }else{
            return false;
        }
    }
    int wi = 0;
    int z=0;
    private boolean fitInWall(int[] matchsticks,int[] w){
        for(int i=0;i<matchsticks.length;i++){
            int b = matchsticks[i];
            if(b!=-1 && w[wi]-b>=0){
                w[wi] =w[wi]-b;
                matchsticks[i] = -1;
                boolean inc=false;
                if(w[wi]==0 && wi<3){
                    wi++;
                    inc=true;
                }
                //print(matchsticks,w);
                //System.out.println((z++));
                //System.out.println("w "+wi+" b "+b+",");
                fitInWall(matchsticks,w);
                //System.out.println((--z));
                if(!check(matchsticks,w)){
                    if(inc){
                        wi--;
                    }
                    matchsticks[i] = b;
                    w[wi] =w[wi]+b;
                    while(i+1<matchsticks.length && matchsticks[i]==matchsticks[i+1] ){
                        i++;
                    }
                   // print(matchsticks,w);
                }else{
                    return true;
                }
            }
        }
        return check(matchsticks,w);
                
    }
    
    
   
    
    private void print(int[] matchsticks,int[] w){
        for(int i=0;i<matchsticks.length;i++){
            System.out.print(matchsticks[i]+",");
        }
        System.out.println(".");
        for(int i=0;i<w.length;i++){
            System.out.print(w[i]+",");
        }
        System.out.println(".");
    }
    private boolean check(int[] matchsticks,int[] w){
        boolean b = true;
        for(int i=0;i<matchsticks.length;i++){
            b &= matchsticks[i]==-1;
        }
        for(int i=0;i<w.length;i++){
            b &= w[i]==0;
        }
        return b;
    }
    
}
