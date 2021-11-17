/*Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
You must do it in place.
  Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
  Constraints:
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
  Follow up:
A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?*/
 
class Solution {
    
    public void setZeroes(int[][] m) {
        Set<String> s =new HashSet<String>();
        int r = m.length;
        int c = m[0].length;
        List<Integer[]> li =new ArrayList<Integer[]>();
                    
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(m[i][j]==0){
                    adjustR(m,i,j,li);
                    break;
                }
            }    
        }
        
        for(Integer[] ind:li){
            int i=0;
            int r1 = ind[0];
            int c1=  ind[1];
            
            while(i<m.length){
                m[i][c1]=0;
                i++;
            }
        }
        
    }
    
     void adjustR(int[][] m,int r,int c,List<Integer[]> li){
        int i=0;
        while(i<m[0].length){
            //if(c!=i)
            if(m[r][i]==0){
                Integer[] a = new Integer[2];
                a[0]=r;a[1]=i;
                li.add(a);
            }else{
                m[r][i]=0;
            }
            i++;
        }
     }
}
