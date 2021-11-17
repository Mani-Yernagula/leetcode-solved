/*We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
If you choose a job that ends at time X you will be able to start another job that starts at time X.
  Example 1:
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:
Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:
Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
  Constraints:
1 <= startTime.length == endTime.length == profit.length <= 5 * 104
1 <= startTime[i] < endTime[i] <= 109
1 <= profit[i] <= 104*/
 
class Solution {
    class Ds{
        int x=0,y=0,z=0;
        public Ds(int x,int y,int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
        
        public String toString(){
            return this.x+" "+this.y;
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<Ds> li =new ArrayList<Ds>();
        for(int i=0;i<startTime.length;i++){
            Ds d=new Ds(startTime[i],endTime[i],profit[i]);
            li.add(d);
        }
        Collections.sort(li,new Comparator(){
            public int compare(Object o1,Object o2){
                return ((Ds)o1).x - ((Ds)o2).x;
            }
        });
        //System.out.println(li);
        for(int i=0;i<startTime.length;i++){
            Ds d = li.get(i);
            startTime[i] = d.x;
            endTime[i] = d.y;
            profit[i] = d.z;
        }
        
        int[] dp= new int[startTime.length];
        //System.out.println(startTime.length);
        for(int i=startTime.length-1;i>-1;i--){
            int s1=startTime[i];
            int e1=endTime[i];
            int p1=profit[i];
            /*while(dp[i]<p1 && startTime[i]==startTime[j]){
                dp[i]=p1;
                j++;
                if(j==startTime.length){
                    break;
                }
                p1 = dp[j];
            }*/
            if(dp[i]<p1){
                dp[i]=p1;
            }
            
            int index = search(startTime,e1);
            while(index-1 >-1 && index-1 <startTime.length && startTime[index]==startTime[index-1]){
                index--;
            }
            while(index >-1 && index <startTime.length && startTime[index]<e1){
                index++;
            }
            if(index >-1 && index <startTime.length){
                dp[i] += dp[index];
            }
            if(i+1<startTime.length && dp[i+1]>dp[i]){
                dp[i]=dp[i+1];
            }
            /*if(i<1000)
            System.out.println(s1+" : "+e1+" : "+(e1-s1)+" @ "+p1+" : "+dp[i]);
            if(index >-1 && index <startTime.length){
                System.out.println(s1+" ^^^^ "+e1+"  "+startTime[index]);
            }*/
            
        }
        //System.out.println("----------------"+dp[0]);
        return dp[0];
    }
    
    
    private int search(int[] arr, int sItem){
       int len = arr.length;
       int min=0,max=len-1;
       int mid= (min+max)/2;
        
       while(min<=max){
           
           if(arr[mid]==sItem){
               return mid;
           }else if(arr[mid]>sItem){
               max = mid-1;
           }else{
               min = mid+1;
           }
           mid=(min+max)/2;
           
       } 
       
       
       return mid; 
    }
    
    
}
