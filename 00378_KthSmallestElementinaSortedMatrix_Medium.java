/*Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
  Example 1:
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:
Input: matrix = [[-5]], k = 1
Output: -5
  Constraints:
n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2*/
 
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null){
            return 0;
        }
        
        if(matrix.length * matrix[0].length < k){
            return 0;
        }
        
        int[] a =merge(matrix,0,matrix.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        return a[k-1];
    }
    
    public int[] merge(int[][] matrix,int s,int e){
        
        if(e-s==1){
           return merge2(matrix[s],matrix[e]);
       }else if(e-s==0){
           return matrix[e];
       }
       
       int[] l = merge(matrix,s,(s+e)/2);
       int[] r = merge(matrix,((s+e)/2)+1,e);
       
       return merge2(l,r);
    }
    
    int[] merge2( int[] l , int[] r){
        int[] a =new int[l.length+r.length];
        int i=0,j=0,k=0;
        while(i<l.length && j<r.length){
            int f1 = l[i];
            int s1 = r[j];
            if(f1<s1){
                a[k++] =f1;
                i++; 
            }else{
                a[k++] =s1;
                j++;
            }
        }
        while(i<l.length){
            a[k++] =l[i];
            i++;
        }
        while(j<r.length){
            a[k++] =r[j];
            j++;
        }
        return a;
    }
}
