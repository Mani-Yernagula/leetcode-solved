/*Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
  Example 1:
Input: n = 3
Output: 5
Example 2:
Input: n = 1
Output: 1
  Constraints:
1 <= n <= 19*/
 
class Solution {
    public int numTrees(int n) {
        Map<String,Integer> m =new HashMap<String,Integer>();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=i+1;
        }
        return gt(a,m);
    }
    
    int gt(int[] a,Map<String,Integer> m) {
        
        if(a.length>2){
            int k=0;
            for(int i=0;i<a.length;i++){
                k+=a[i];
            }
            if(m.containsKey(k+","+a.length)){
                return m.get(k+","+a.length);
            }
        }
        int ret = 0;
        if(a.length==0){
            return 0;
        }
        if(a.length==1){
            return 1;
        }
        
        if(a.length==2){
            return 2;
        }
        for(int i=0;i<a.length;i++){
            int[] x = Arrays.copyOfRange(a,0,i);
            int[] y = Arrays.copyOfRange(a,i+1,a.length);
            int ln = gt(x,m);
            int rn = gt(y,m);
            if(ln!=0 && rn!=0){
                ret += ln * rn;
            }else {
                ret += ln==0?rn:ln;
            }           
            
        }
        int k=0;
            for(int i=0;i<a.length;i++){
                k+=a[i];
            }
        m.put(k+","+a.length,ret);
        return ret;
    }
}
