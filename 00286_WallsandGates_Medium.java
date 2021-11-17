/*You are given an m x n grid rooms initialized with these three possible values.
-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
  Example 1:
Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
Example 2:
Input: rooms = [[-1]]
Output: [[-1]]
Example 3:
Input: rooms = [[2147483647]]
Output: [[2147483647]]
Example 4:
Input: rooms = [[0]]
Output: [[0]]
  Constraints:
m == rooms.length
n == rooms[i].length
1 <= m, n <= 250
rooms[i][j] is -1, 0, or 231 - 1.*/
 
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int i = 0, j = 0;
        for (int[] row : rooms) {
            j=0;
            for (int c : row) {
                if (c == 0)
                    bfs(rooms, new int[] { i, j });
                j++;
            }
            i++;
        }
    }
    
    void p(int[][] rooms) {
        for (int[] row : rooms) {
            for (int c : row) {
                System.out.print(","+c);
            }
            System.out.println("");
        }
    }

    int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int inf = Integer.MAX_VALUE;

    void bfs(int[][] rooms, int[] g) {
        Queue<int[]> q = new LinkedList<int[]>();
        Set<String> vi =new HashSet<String>();
        q.add(g);
        int de = q.size();
        int i = 0;
        int cd = 1;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            i++;
            
            if(vi.contains(c[0]+","+c[1])) {
                if (de == i) {
                    de = q.size();
                    i = 0;
                    cd++;
                }    
                continue;
            }
            vi.add(c[0]+","+c[1]);
            

            for (int[] ad : adj) {
                int x = c[0] + ad[0];
                int y = c[1] + ad[1];
                if (x > -1 && x < rooms.length && y > -1 && y < rooms[0].length) {
                    if (rooms[x][y] == -1 || rooms[x][y] == 0) {
                        continue;
                    } else if (rooms[x][y] == inf || rooms[x][y] > cd) {
                        rooms[x][y] = cd;
                    }
                    if(!vi.contains(x+","+y)) 
                    q.add(new int[] {x,y});
                }
            }
            if (de == i) {
                de = q.size();
                i = 0;
                cd++;
            }
        }
    }

}
