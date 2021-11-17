/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
  Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
  Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104*/
 
class Solution {
    public int[][] merge(int[][] b) {
        int c=0;
        for(int i=0;i<b.length;){
            int j=0;
            int l=0;
            while(j<b.length){
                if(i!=j && b[i][1]>=b[j][0] && b[i][0]<=b[j][0]){
                    b[i][1]=Math.max(b[j][1],b[i][1]);
                    b[j][0]=Integer.MIN_VALUE;
                    b[j][1]=Integer.MIN_VALUE;
                    c++;
                    l++;
                }
                //System.out.println(i+"::"+j);
                
                //print(b);
                j++;
            }
            while(l==0 && ++i<b.length && b[i][0]==Integer.MIN_VALUE){
               
            }
            //System.out.println(i);
        }
        int[][] a = new int[b.length-c][2];
        int k=0;
        for(int j=0;j<b.length;j++){
            if(b[j][0]!=Integer.MIN_VALUE){
                a[k][0]=b[j][0];
                a[k++][1]=b[j][1];
                
            }
        }
        return a;
    }
    
    public void print(int[][] b){
         for(int i=0;i<b.length;i++){
              for(int j=0;j<b[i].length;j++){
                  System.out.print(b[i][j]+",");
              }
             System.out.println("--");
         }
        System.out.println("***********");
    }
        
    
}
