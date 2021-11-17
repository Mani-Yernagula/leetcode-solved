/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
  Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
  Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105*/
 
class Solution {
    public int trap(int[] h) {
        
        if(h.length==0){
            return 0;
        }
        List<Integer> li =new ArrayList<Integer>();
        
        li.add(h[0]);
        int ret =0;
        for(int i=1;i<h.length;i++){
           // System.out.println(li);
            if(li.get(0)>h[i]){
                if(li.get(li.size()-1)>=h[i]){
                    li.add(h[i]);
                }else{
                  //  System.out.println("asc in "+li);
                    int j=1;
                    while(j<li.size()){
                        if(h[i]>=li.get(j)){
                            int z = h[i]-li.get(j);
                            li.set(j,h[i]);
                            ret+=z;
                        }
                        //System.out.println(ret);
                        j++;
                    }
                    li.add(h[i]);
                }
                
            }else{
               // System.out.println("asc "+li);
                int j=1;
                    while(j<li.size()){
                        if(li.get(0)>=li.get(j)){
                            int z = li.get(0)-li.get(j);
                            li.set(j,li.get(0));
                            ret+=z;
                        }
                       // System.out.println(ret);
                        j++;
                    }
                li.clear();
                li.add(h[i]);
            }
        }
        System.out.println("---------------");
        return ret;
        
    }
}
