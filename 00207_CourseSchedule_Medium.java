/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
  Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
  Constraints:
1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.*/
 
class Solution {
    public boolean canFinish(int num, int[][] prerequisites) {
     // three states
        // 0, not visited
        // 1, being processed
        // 2, visited
        // build graph and visited
        int[] visited = new int[num];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<num;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }
        //System.out.println(graph);
        for(int i=0;i<num;i++){
        //System.out.println("visit "+i);
            if(!DFS(graph,visited,i)){
                return false;
            }
        }
        return true;
    }
    
    private boolean DFS(List<List<Integer>> graph, int[] visited, int index) {
        
        //System.out.println("");
        if(visited[index]==2){
            return true;
        }
        if(visited[index]==1){
            return false;
        }
        visited[index]=1;
        List<Integer> lis = graph.get(index);
        for(int i=0;i<lis.size();i++){
            if(!DFS(graph,visited,lis.get(i))){
                return false;
            }
        }
        visited[index]=2;
        return true;
    }
}
