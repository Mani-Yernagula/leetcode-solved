/*Given n points on a 2D plane, find if there is such a line parallel to the y-axis that reflects the given points symmetrically.
In other words, answer whether or not if there exists a line that after reflecting all points over the given line, the original points' set is the same as the reflected ones.
Note that there can be repeated points.
  Example 1:
Input: points = [[1,1],[-1,1]]
Output: true
Explanation: We can choose the line x = 0.
Example 2:
Input: points = [[1,1],[-1,-1]]
Output: false
Explanation: We can't choose a line.
  Constraints:
n == points.length
1 <= n <= 104
-108 <= points[i][j] <= 108
  Follow up: Could you do better than O(n2)?*/
 
class Solution {
    public boolean isReflected(int[][] points) {
        if(points.length==1){
            return true;
        }
        
        Arrays.sort(points,new Comparator<int[]>(){
            public int compare(int[] i1,int[] i2){
                if(i1[1]==i2[1]){
                    return i1[0]-i2[0];    
                }
                return i1[1]-i2[1];
            }
        });
        
        //System.out.println("---------");
        int i=0;
        int j=0;
        int c = points[0][1];
        double yxis = Double.MAX_VALUE;
        Set<String> set=new HashSet<String>();
        int di=0;
        for(;i<points.length;){
            
            
            
            while(j+1 < points.length && c==points[j+1][1]){
                j++;
            }
            di=j;
            
            
            while(i<j){
               int[] x= points[i];
               int[] y= points[j];
               double z= (new Double(x[0])+new Double(y[0]))/2;
               //System.out.println(x[0]+","+x[1]+":"+y[0]+","+y[1]+">>>"+yxis);
               //System.out.println(i+","+j+":"+yxis+","+z);
               if(yxis==Double.MAX_VALUE){
                   yxis=z;
               }else if(yxis!=z){
                   return false;
               } 
               set.add(x[0]+","+x[1]);
               set.add(y[0]+","+y[1]);
               i++;
               j--;
                
            }
            if(i==j){
               int[] x= points[i];
               //System.out.println(i+","+j+":"+yxis+","+z);
               if(yxis==Double.MAX_VALUE){
                   yxis=x[0];
                   set.add(x[0]+","+x[1]);
               }else if(yxis!=x[0] && !set.contains(x[0]+","+x[1])){
                   //System.out.println(x[0]+","+x[1]+">>>"+yxis);
                   return false;
               }
            }
            i=di+1;
            j=i;
            if(i < points.length)
            c=points[i][1];
        }
        
        return true;
    }
}
