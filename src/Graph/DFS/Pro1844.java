package Graph.DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Pro1844 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m; // node/edge
    static boolean[][] visited; //방문배열

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        return bfs(0,0, maps);
    }
    public int bfs(int x, int y, int[][] maps){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y,1));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            if(pair.x == n -1 && pair.y == m-1) return pair.cnt;

            for(int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if(nx >= 0 && ny <= 0 && nx < n && ny < m) {
                    if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Pair(nx, ny, pair.cnt + 1));
                    }
                }
            }
        }
        //적의 진영까지 가지 못했을 경우,
        return -1;
    }
    public class Pair {
        int x;
        int y;
        int cnt;
        public Pair (int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;

        }
    }
}
