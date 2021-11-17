/*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
  Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
  Constraints:
1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.*/
 
class LRUCache {
    
    HashMap<Integer,DNode> map =new HashMap<Integer,DNode>();
    
    class DNode{
        DNode next;
        DNode prev;
        int key;
        int val;
        public  DNode(int key,int val){
            this.key=key;
            this.val=val;
        }
        
        public DNode removeSelf(){
            if(this.next!=null && this.prev!=null){
                DNode temp = this.prev;
                this.next.prev = temp;
                temp.next = this.next;
                this.next =null;
                this.prev = null;
                return this;
            }
            return null;
        }
        public String toString(){
            return "["+val+"] > "+(next);
        }
        
    }
    
    int cap;
    DNode head=new DNode(-1,-1);
    DNode tail=new DNode(-1,-1);

    public LRUCache(int capacity) {
        this.cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            System.out.println("getting key "+key);
            DNode n = map.get(key);
            n.removeSelf();
            addToTop(n);
            //System.out.println("after adjust key "+n);
            return n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            //System.out.println("has key "+key);
            DNode n = map.get(key);
            n.val =value;
            map.put(key,n);
            n.removeSelf();
            //System.out.println("self removed "+n);
            addToTop(n);
            //System.out.println("added to top "+n);
        }else{
            DNode n = new DNode(key,value);
            map.put(key,n);
            addToTop(n);
            //System.out.println("added to top new ele "+n);
        }
        if(map.keySet().size()>cap){
            DNode d=  removeAtEnd();
            map.remove(d.key);
           // System.out.println("removed at end "+head);
        }
    }
    
    void addToTop(DNode node){
        DNode temp = head.next;
        
        head.next = node;
        node.prev= head;
        
        node.next = temp;
        temp.prev = node;
    }

    DNode removeAtEnd(){
        if(tail.prev!=null){
            DNode del = tail.prev;
            DNode temp = del.prev;
            
            temp.next = tail;
            tail.prev = temp;
            del.next=null;
            del.prev=null;
            return del;
        }
        return null;
    }
    
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
