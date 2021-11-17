/*The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:
MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
  Example 1:
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
  Constraints:
-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
  Follow up:
If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?*/
 
class MedianFinder {
    
    ArrayList<Integer> li =null;

    /** initialize your data structure here. */
    public MedianFinder() {
        li =new ArrayList<Integer>();
    }
    
    public void addNum(int num){
        if(li.isEmpty()){
             li.add(0,num);
            return;
        }
        int ix = bs(li,num);
        //System.out.println(ix);
        /*if(num<0){
            ix = ix==0?0:ix-1;
        }else{
            ix = ix+1;
        }*/
        if(li.get(ix)<num){
            ix = ix+1;
        }
        li.add(ix,num);
       //System.out.println(li);
    }
    
    int bs(ArrayList<Integer> arr, int x) { 
        int left = 0, right = arr.size() - 1;
        int mid = left + (right - left) / 2; 
        
        while (left <= right)
        { 
            mid = left + (right - left) / 2; 
    
            // Check if x is present at mid 
            if (arr.get(mid) == x) 
                return mid; 
    
            // If x greater, ignore left half 
            if (arr.get(mid) < x) 
                left = mid + 1; 
    
            // If x is smaller, ignore right half 
            else
                right = mid - 1; 
        } 
    
        // if we reach here, then element was 
        // not present 
        return mid<0?0:mid; 
    }
    
    //0 1 2 3 4 5 6 7 
    public double findMedian() {
        if(li.size() % 2==0){
            int x = li.size()/2;
            int y = x-1;
            double z =li.get(x)+li.get(y);
            //System.out.println(x+" : "+y);
            return z/2;
        }else{
            int x  =li.size()/2;
            //System.out.println(x);
            //System.out.println(x);
            return li.get(x);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
