/*There are n tasks assigned to you. The task times are represented as an integer array tasks of length n, where the ith task takes tasks[i] hours to finish. A work session is when you work for at most sessionTime consecutive hours and then take a break.
You should finish the given tasks in a way that satisfies the following conditions:
If you start a task in a work session, you must complete it in the same work session.
You can start a new task immediately after finishing the previous one.
You may complete the tasks in any order.
Given tasks and sessionTime, return the minimum number of work sessions needed to finish all the tasks following the conditions above.
The tests are generated such that sessionTime is greater than or equal to the maximum element in tasks[i].
  Example 1:
Input: tasks = [1,2,3], sessionTime = 3
Output: 2
Explanation: You can finish the tasks in two work sessions.
- First work session: finish the first and the second tasks in 1 + 2 = 3 hours.
- Second work session: finish the third task in 3 hours.
Example 2:
Input: tasks = [3,1,3,1,1], sessionTime = 8
Output: 2
Explanation: You can finish the tasks in two work sessions.
- First work session: finish all the tasks except the last one in 3 + 1 + 3 + 1 = 8 hours.
- Second work session: finish the last task in 1 hour.
Example 3:
Input: tasks = [1,2,3,4,5], sessionTime = 15
Output: 1
Explanation: You can finish all the tasks in one work session.
  Constraints:
n == tasks.length
1 <= n <= 14
1 <= tasks[i] <= 10
max(tasks[i]) <= sessionTime <= 15*/
 
class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        // sort desendingly
        // we know that the minSessionTimes is between 1 to # number of tasks
        // then we can use dfs to find from 1 to n, which one works first
        // Copy Right to a classmate.
        Arrays.sort(tasks);
        int s = 0, t = tasks.length - 1;
        while (s <= t) {
            int temp = tasks[s];
            tasks[s] = tasks[t];
            tasks[t] = temp;
            s++;
            t--;
        }
        
        for (int n = 1; n < tasks.length; n++) {
            int[] remain = new int[n];
            for (int i = 0; i < n; i++) {
                remain[i] = sessionTime;
            }
            if (canWork(tasks, 0, remain)) return n;
        }
        return tasks.length;
    }
    
    private boolean canWork(int[] tasks, int curr, int[] remain) {
        if (curr == tasks.length) return true;
        for (int i = 0; i < remain.length; i++) {
            if (i > curr) continue; // if i th bucket's index is bigger that current task's index, we continue as it's impossible bc the 
                worst east is that i == index when worksession is equal to task time.
            if (remain[i] >= tasks[curr]) {
                remain[i] -= tasks[curr];
                if (canWork(tasks, curr + 1, remain)) return true;
                remain[i] += tasks[curr];
            }
        }
        return false;
    }
    
}
