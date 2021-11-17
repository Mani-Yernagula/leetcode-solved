/*A certain bug's home is on the x-axis at position x. Help them get there from position 0.
The bug jumps according to the following rules:
It can jump exactly a positions forward (to the right).
It can jump exactly b positions backward (to the left).
It cannot jump backward twice in a row.
It cannot jump to any forbidden positions.
The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.
Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.
  Example 1:
Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
Output: 3
Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
Example 2:
Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
Output: -1
Example 3:
Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
Output: 2
Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.
  Constraints:
1 <= forbidden.length <= 1000
1 <= a, b, forbidden[i] <= 2000
0 <= x <= 2000
All the elements in forbidden are distinct.
Position x is not forbidden.*/
 
class Solution {
    public int minimumJumps(int[] fbdn, int a, int b, int x) {
        if(x==0){
            return 0;
        }
        
        int maxLen = Math.max(x+a,x+b);
        maxLen=2000+x+a+b+b+1;
        //maxLen=400;
        System.out.println(maxLen);
        
        Queue<Integer> q =new LinkedList<Integer>();
        int[] dp=new int[maxLen+1];
        
        int i=0;
        while(i<maxLen+1){
            dp[i]=Integer.MAX_VALUE;
            i++;
        }
        for(int x1:fbdn){
            if(x1<dp.length)
            dp[x1]=-2;
        }
        dp[0]=0;
        
        if(dp[a]!=-2){
            dp[a]=1;
            q.add(a);
        }
        while(!q.isEmpty()){
           // System.out.println(q);
            int cu = q.remove();
            
            if(cu>-1 && cu<dp.length){
                if(cu==x){
                    return dp[cu];
                }
                int fo = cu+a;
                int ba = cu-b;
                //System.out.println(cu+","+fo+","+ba+","+b2);
                if(fo>-1 && fo<dp.length && dp[fo]!=-2){
                    dp[fo] = dp[fo]>0?Math.min(dp[fo],dp[cu]+1):dp[cu]+1;
                     q.add(fo);
                }
                if(ba>-1 && ba<dp.length && dp[ba]!=-2){
                    if(ba==x){
                        return dp[cu]+1;
                    }
                    dp[ba] = dp[ba]>0?Math.min(dp[ba],dp[cu]+1):dp[cu]+1;
                    if(ba+a>-1 && ba+a<dp.length && dp[ba+a]!=-2){
                        if(dp[ba+a]>dp[ba]+1) {
                            dp[ba+a]=dp[ba]+1;
                            q.add(ba+a);
                        }
                        
                        
                       
                    }
                    
                }
                
            }
        }
        return -1;
    }
}
