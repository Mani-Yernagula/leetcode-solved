/*An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.
Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.
Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.
  Example 1:
Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:
Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Example 3:
Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
Output: false
  Constraints:
rect1.length == 4
rect2.length == 4
-109 <= rec1[i], rec2[i] <= 109
rec1 and rec2 represent a valid rectangle with a non-zero area.*/
 
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        int[] bl1 = new int[]{rec1[0],rec1[1]};
        int[] tr1 = new int[]{rec1[2],rec1[3]};
        
        int[] br1 = new int[]{rec1[2],rec1[1]};
        int[] tl1 = new int[]{rec1[0],rec1[3]};
        
        System.out.println("rec1"+bl1[0]+""+bl1[1]);
        System.out.println("rec1"+br1[0]+""+br1[1]);
        System.out.println("rec1"+tl1[0]+""+tl1[1]);
        System.out.println("rec1"+tr1[0]+""+tr1[1]);
        
        int[] bl2 = new int[]{rec2[0],rec2[1]};
        int[] tr2 = new int[]{rec2[2],rec2[3]};
        
        int[] br2 = new int[]{rec2[2],rec2[1]};
        int[] tl2 = new int[]{rec2[0],rec2[3]};
        
        System.out.println("rec2"+bl2[0]+""+bl2[1]);
        System.out.println("rec2"+br2[0]+""+br2[1]);
        System.out.println("rec2"+tl2[0]+""+tl2[1]);
        System.out.println("rec2"+tr2[0]+""+tr2[1]);
        
        
         System.out.println("tr1[0]<bl2[0] &&"+tr1[0] +"<"+ bl2[0]+ "tr1[1]<bl2[1]  &&"+ tr1[1]+"<"+bl2[1] );
        
        
        if(tr1[0]>bl2[0] && tr1[1]>bl2[1] && bl1[0]<tr2[0] && bl1[1]<tr2[1]){
            return true;
        }
        
        
        return false;
        
    }
}
