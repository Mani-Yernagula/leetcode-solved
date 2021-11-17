/*You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
  Example 1:
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:
Input: nums = [-1]
Output: [0]
Example 3:
Input: nums = [-1,-1]
Output: [0,0]
  Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104*/
 
class Solution {
    
    class TN{
        TN left;
        TN right;
        int val;
        int height;
            
        int count;
        int dup;
        public TN(int val){
            this.val=val;
            count = 0;
            dup=0;
        }
        public String toString(){
            return val +" : " +count;
        }
    }
    
     public List<Integer> countSmaller(int[] nums) {
        int k=nums.length;
          
        System.out.println(k);
         
        Integer[] ret = new Integer[k];
        TN root = null;//new TN(nums[k-1]);
          
          
         
        for(int i=k-1;i>-1;i--){
             TN st = root; 
             ret[i]=0;
        
             root = findOrAddToTree(st,nums[i],ret,i);
             
             st = root; 
             ret[i] =findInTree(st,nums[i]);
             
             if(i%2000==0)
                System.out.println(i+" : "+nums[i]+" : "+ret[i]);
          }
         return Arrays.asList(ret);
     }
    
    private int findInTree(TN root,int val){
         if(root.val>val){
             return findInTree(root.left,val);
         }else{
             if(root.val<val){
                return root.count+1+root.dup+findInTree(root.right,val);
             }else{
                 return root.count;
             }
         }
    }
    
     private TN findOrAddToTree(TN root,int val,Integer[] ret,int reti){
         if(root==null){
             return new TN(val);
         }
         
         //System.out.println(root);
         
         if(root.val>val){
             root.count++;
             root.left = findOrAddToTree(root.left,val,ret,reti);
         }else{
             if(root.val<val){
                root.right = findOrAddToTree(root.right,val,ret,reti);
             }else{
                 root.dup++;
             }
         }
         root.height = 1 + max(height(root.left),
                              height(root.right));
 
        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(root);
 
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && val < root.left.val)
            return rightRotate(root);
 
        // Right Right Case
        if (balance < -1 && val > root.right.val)
            return leftRotate(root);
 
        // Left Right Case
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
 
        // Right Left Case
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
         
         
         return root;
     }
    
     int height(TN N) {
        if (N == null)
            return 0;
 
        return N.height;
    }
 
    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
 
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    TN rightRotate(TN y) {
        TN x = y.left;
        TN T2 = x.right;
        y.count -= y.left.count+1+y.left.dup; //only needed for this problem
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    TN leftRotate(TN x) {
        TN y = x.right;
        TN T2 = y.left;
        x.right.count += x.count+1+x.dup; //only needed for this problem
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
    
    // Get Balance factor of node N
    int getBalance(TN N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
    
         
    
}
