/*Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
  Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
  Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length*/
 
class Solution {
    public int longestOnes(int[] nums, int k) {
        LinkedList<Integer> wi=new LinkedList<Integer>();
        int l= nums.length;
        int i=0,max=0;
        boolean fo=false;
        while(wi.size()<k && i<l){
            if(nums[i]==0){
                wi.add(i);
            }else{
                fo =true;
            }
            i++;
        }
        //System.out.println(wi);
        
        if(k==0){
            int j=0;
            boolean seq=false;
            while(j<l){
                if(nums[j]==0){
                    if(seq){
                        seq=false;
                        max = wi.getLast()-wi.getFirst()+1;
                        wi.clear();
                    }
                }else{
                    if(!seq){
                        seq=true;
                    }
                    wi.add(j);
                }
                //System.out.println("k0 "+wi);
                j++;
            }
            if(!wi.isEmpty()){
                max = wi.getLast()-wi.getFirst()+1;;
            }
            
        }else if(wi.size()<k){
            return nums.length;
        }else{
            if(fo || (i+1<l &&  nums[i+1]==1)){
                max = calc(wi,max,l,nums);
            }
            while(!wi.isEmpty() && wi.getLast()<l){
                Integer f = wi.getFirst();
                Integer o = wi.getLast();
                if(f!=o){
                    int n = o+1;
                    while(n<l && nums[n]==1){
                       n++;    
                    }
                    wi.removeFirst();
                    if(n<l)
                    wi.add(n);
                }else{
                    break;
                }
               // System.out.println(wi);
                max = calc(wi,max,l,nums);
            }
        }
        
       
        
       
          System.out.println("------------------------------------");
            
      return max;  
        
    }
    
    int calc(LinkedList<Integer> wi,int max,int len,int[] nums){
                 
               int x=0,y=0,z=0;
               int f = wi.isEmpty()?-1:wi.getFirst();
               int l = wi.isEmpty()?len:wi.getLast();
               int m=f;
              // System.out.println("cal "+wi);
               while(--f>-1 && nums[f]==1){
                       x++;
               }
               if(l<nums.length)
               y=l-m+1;
               while(l+1<nums.length && nums[l+1]==1){
                   z++;
                   l++;    
               }
                //System.out.println("x "+x+" y "+y+" z "+z );
               x = x+y+z;
              max=max<x?x:max;
             return max;
    }
                     
}
