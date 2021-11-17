/*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
  Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:
Input: n = 1
Output: 1
  Constraints:
1 <= n <= 9*/
 
class Solution {
    int ret = 0;
    public int totalNQueens(int n) {
        List<List<String>> b = new ArrayList<List<String>>();
        for(int i=0;i<n;i++){
            List<String> r = new ArrayList<String>();
            for(int j=0;j<n;j++){
                r.add(".");
            }
            b.add(r);
        }
        solveNQueens(b,0,n);
        return ret;
    }
    
    void p(List<List<String>> b){
        for(int i=0;i<b.size();i++){
            for(int j=0;j<b.size();j++){
                System.out.print(b.get(i).get(j));
            }
            System.out.println("");
        }
    }
    
    public boolean solveNQueens(List<List<String>> b,int i,int n) {
        int j=0;
        boolean place = false;
        while(j<n){
            //System.out.println(i+" "+j);
            if(canPlace(b,i,j)){
                b.get(i).set(j,"Q");
                if(i+1<n){
                      solveNQueens(b,i+1,n);
                }else{
                    ret++;
                    //p(b);
                    //System.out.println("****************");
                }
                b.get(i).set(j,".");
            }
            j++;
        }
        return false;
    }
    
    boolean canPlace(List<List<String>> b,int  i,int j){
        int s = b.size();
        int i1=i;
        int j1=j;
        int i2=i;
        int j2=j;
        int i3=i;
        int j3=j;
        int i4=i;
        int j4=j;
        
        while(i1-1 >-1 && j1-1>-1){
            i1--;j1--;
        }
        
       // System.out.println(i1+" "+j1+" "+i2+" "+j2+" "+i3+" "+j3+" "+i4+" "+j4);
        
        while(i2+1 < s && j2-1>-1){
            i2++;j2--;
        }
        
       // System.out.println(i1+" "+j1+" "+i2+" "+j2+" "+i3+" "+j3+" "+i4+" "+j4);
        
        while(i3-1 > -1){
            i3--;
        }
        
       // System.out.println(i1+" "+j1+" "+i2+" "+j2+" "+i3+" "+j3+" "+i4+" "+j4);
        
        while(j4-1 > -1){
            j4--;
        }
        
       // System.out.println(i1+" "+j1+" "+i2+" "+j2+" "+i3+" "+j3+" "+i4+" "+j4);
        
        while(i1<s && j1<s){
            if(b.get(i1).get(j1).equals("Q")){
                return false;
            }
            i1++;j1++;
        }
        while(i2 > -1 && j2<s){
            if(b.get(i2).get(j2).equals("Q")){
                return false;
            }
            i2--;j2++;
        }
        
        while(i3 < s){
            if(b.get(i3).get(j3).equals("Q")){
                return false;
            }
            i3++;
        }
        
        while(j4 < s){
            if(b.get(i4).get(j4).equals("Q")){
                return false;
            }
            j4++;
        }
        return true;
    }
}
