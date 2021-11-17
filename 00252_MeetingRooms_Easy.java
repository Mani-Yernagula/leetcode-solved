/*Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
  Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:
Input: intervals = [[7,10],[2,4]]
Output: true
  Constraints:
0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 106*/
 
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int[] a =new int[1000000];
        for(int[] i:intervals){
            a[i[0]]=a[i[0]]+1;
            a[i[1]]=a[i[1]]-1;
        }
        /*for(int x=0;x<50;x++){
            System.out.print(","+a[x]);
        }
        System.out.println("");*/
        int c=0;
        for(int x:a){
            c+=x;
            if(c>1)
                return false;
        }
        return true;
    }
}
