package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited; //방문 배열
    int n, m;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length; //row
        m = maps[0].length; //col
        visited = new boolean[n][m];


        //여기서 xy는 시작점인가


        return  bfs(0,0, maps);
    }

    public int bfs(int x, int y, int[][] maps) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair (x, y, 1));
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            if(pair.x == n - 1 && pair.y == m - 1) return pair.cost;
            for(int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Pair(nx, ny, pair.cost + 1));
                    }
                }
            }
        }
        return -1;
    }
    public class Pair {
        int x;
        int y;
        int cost;

        public Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
