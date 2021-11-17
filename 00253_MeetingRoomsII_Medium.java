/*Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
  Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1
  Constraints:
1 <= intervals.length <= 104
0 <= starti < endi <= 106*/
 
class Solution {
    public int minMeetingRooms(int[][] intervals) {
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
        int max=c;
        for(int x:a){
            c+=x;
            max = Math.max(max,c);
        }
        return max;
    }
}
