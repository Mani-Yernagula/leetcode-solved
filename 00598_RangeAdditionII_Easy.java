/*You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
Count and return the number of maximum integers in the matrix after performing all the operations.
  Example 1:
Input: m = 3, n = 3, ops = [[2,2],[3,3]]
Output: 4
Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
Example 2:
Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
Output: 4
Example 3:
Input: m = 3, n = 3, ops = []
Output: 9
  Constraints:
1 <= m, n <= 4 * 104
0 <= ops.length <= 104
ops[i].length == 2
1 <= ai <= m
1 <= bi <= n*/
 
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        //System.out.println("------------------------");
        List<int[]> arr =new ArrayList<int[]>();
        for(int[] x:ops){
            arr.add(x);
        }
        Collections.sort(arr, new Comparator(){
            public int compare(Object o1,Object o2){
                int[] x1=(int[]) o1;
                int[] x2=(int[]) o2;
                if(x1[0]==x2[0]){
                    return x1[1]-x2[1];
                }
                return x1[0]-x2[0];
            }
        });
        if(!arr.isEmpty()){
            int[] r=arr.get(0);
            for(int i=1;i<arr.size();i++){
                int[] x=arr.get(i);
                //System.out.println("["+x[0]+","+x[1]+"]");
                x[0] = Math.min(r[0],x[0]);
                x[1] = Math.min(r[1],x[1]);
            }
            Collections.sort(arr, new Comparator(){
                public int compare(Object o1,Object o2){
                    int[] x1=(int[]) o1;
                    int[] x2=(int[]) o2;
                    if(x1[0]==x2[0]){
                        return x1[1]-x2[1];
                    }
                    return x1[0]-x2[0];
                }
            });
            /*for(int[] x:arr){
                System.out.println("["+x[0]+","+x[1]+"]");
            }*/
        
            int[] r1=arr.get(0);
            int ret=r1[0]*r1[1];
            //System.out.println(ret);
            return ret;
        }
        
        return m*n;
    }
}
