/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
  Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
  Constraints:
-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.*/
 
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public MinStack() {
        
    }
    
    public void push(int x) {
        s.push(x);
        if(min.isEmpty()){
            min.push(x);
        }else if(!min.isEmpty() && min.peek()>x){
            min.push(x);
        }else{
            min.push(min.peek());
        }
        
    }
    
    public void pop() {
       int x= s.pop();
        if(!min.isEmpty()){
            min.pop();
        }
        
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
