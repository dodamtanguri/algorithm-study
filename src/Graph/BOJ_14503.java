package Graph;

import java.util.*;
import java.io.*;

public class BOJ_14503 {
    static int n, m, r, c, d, ans;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(ans);
    }

    static boolean isMovable(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        return !(nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny] || arr[nx][ny] == 1);
    }

    //dir 북 동 남 서
    //    0  1 2 3
    //dy -1 0 1 0
    //dx 0 1 0 -1
    //왼쪽 방향으로 4방향을 탐색 >> 반시계방향 90도
    private static void clean(int x, int y, int dir) {
        if (!visit[x][y]) {
            visit[x][y] = true;
            ans++;
        }
        for(int i = 0; i < 4; i++) {
            //청소기의 방향을 바꾸는 연산
            dir = (dir + 3) % 4;
            if(isMovable(x,y,dir)) {
                clean(x + dx[dir], y+ dy[dir], dir);
            }
        }

        int backDir = (dir + 2) % 4;

        int backX = x + dx[backDir];
        int backY = y + dy[backDir];
        // 후진하는 경우
        if(isMovable(backX,backY, dir)) {
            clean(backX, backY, dir);
        }

    }
}
