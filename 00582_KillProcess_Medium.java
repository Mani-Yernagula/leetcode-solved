/*You have n processes forming a rooted tree structure. You are given two integer arrays pid and ppid, where pid[i] is the ID of the ith process and ppid[i] is the ID of the ith process's parent process.
Each process has only one parent process but may have multiple children processes. Only one process has ppid[i] = 0, which means this process has no parent process (the root of the tree).
When a process is killed, all of its children processes will also be killed.
Given an integer kill representing the ID of a process you want to kill, return a list of the IDs of the processes that will be killed. You may return the answer in any order.
  Example 1:
Input: pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
Output: [5,10]
Explanation: The processes colored in red are the processes that should be killed.
Example 2:
Input: pid = [1], ppid = [0], kill = 1
Output: [1]
  Constraints:
n == pid.length
n == ppid.length
1 <= n <= 5 * 104
1 <= pid[i] <= 5 * 104
0 <= ppid[i] <= 5 * 104
Only one process has no parent.
All the values of pid are unique.
kill is guaranteed to be in pid.*/
 
class Solution {
    
   class TN {
        List<TN> cs=new ArrayList<TN>();
        int val;

        public TN(int val) {
            this.val = val;
        }
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> li = new ArrayList<Integer>();
        HashMap<Integer, TN> m = new HashMap<Integer, TN>();
        TN r = null;
        for (int i = 0; i < pid.size(); i++) {
            TN p = null,c=null;
            if (m.containsKey(ppid.get(i))) {
                p = m.get(ppid.get(i));
            } else {
                p = new TN(ppid.get(i));
                m.put(p.val, p);
            }
            if (m.containsKey(pid.get(i))) {
                c = m.get(pid.get(i));
            } else {
                c = new TN(pid.get(i));
                m.put(c.val, c);
            }
            p.cs.add(c);
            if (p.val == 0)
                r = p;
        }
        TN node = fn(r, kill);
        //System.out.println(node.val);
        t(node, li);
        return li;
    }

    void t(TN r, List<Integer> li) {
        if (r == null) {
            return;
        }else {
            li.add(r.val);
            for(TN c:r.cs){
                t(c,li);
            }
        }
        
        //System.out.println(r.val);
    }

    TN fn(TN root, int val) {
        if (root == null) {
            return null;
        } else {
            if(root.val==val){
                return root;
            }
            for(TN c:root.cs){
                TN ret = fn(c,val);
                if(ret!=null){
                    return ret;
                }
            }
        }
        return null;
    }

    
}

