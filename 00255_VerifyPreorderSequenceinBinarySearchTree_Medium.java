/*Given an array of unique integers preorder, return true if it is the correct preorder traversal sequence of a binary search tree.
  Example 1:
Input: preorder = [5,2,1,3,6]
Output: true
Example 2:
Input: preorder = [5,2,6,1,3]
Output: false
  Constraints:
1 <= preorder.length <= 104
1 <= preorder[i] <= 104
All the elements of preorder are unique.
  Follow up: Could you do it using only constant space complexity?*/
 
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        return verifyPreorder(preorder,inorder,0,preorder.length-1);
    }
    
    int top=0;
    
    int binarySearch(int arr[], int l, int r, int x){
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
    
    public boolean verifyPreorder(int[] pq,int[] iq,int i,int j) {
        boolean ret = true;
        if(top<pq.length){
            int r = pq[top];
            top++;
            int ind = binarySearch(iq,i,j,r);
            //System.out.println(r+" : "+ind+ " " +i+ " "+j+" : "+pq+" : "+iq);
            if(ind==-1)
                return false;
            
            if(ind-1>i-1){
                ret = verifyPreorder(pq,iq,i,ind-1);
                //System.out.println(" l "+ret);
                if(!ret) 
                    return false;
            }
            if(ind+1<j+1){
                ret = verifyPreorder(pq,iq,ind+1,j);
                //System.out.println(" r "+ret);
                if(!ret) 
                    return false;
                
            }
        }
        return ret;   
    }
}
