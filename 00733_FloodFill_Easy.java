/*An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
Return the modified image after performing the flood fill.
  Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
  Constraints:
m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], newColor < 216
0 <= sr < m
0 <= sc < n*/
 
class Solution {
   
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        List<int[]> li  =new ArrayList<int[]>();
        int r= image.length;
        int c = image[0].length;
        int[] a = new int[]{sr,sc};
        int oc = image[sr][sc];
        if(oc==newColor){
            return image;
        }
        li.add(a);
        while(!li.isEmpty()){
            int[] t= li.remove(0);
            int[] u = new int[]{t[0]-1,t[1]};
            int[] d = new int[]{t[0]+1,t[1]};
            int[] l = new int[]{t[0],t[1]-1};
            int[] r1 = new int[]{t[0],t[1]+1};
            if(u[0]>-1 && image[u[0]][u[1]]==oc){
                li.add(u);
            }
            if(d[0]<r && image[d[0]][d[1]]==oc){
                li.add(d);
            }
            if(l[1]>-1 && image[l[0]][l[1]]==oc){
                li.add(l);
            }
            if(r1[1]<c && image[r1[0]][r1[1]]==oc){
                li.add(r1);
            }
            image[t[0]][t[1]]=newColor;
        }
        return image;
    }
}
