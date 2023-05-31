import java.util.*;
import java.io.*;

public class Main {
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

    static void clean(int x, int y, int dir) {
        if (!visit[x][y]) {
            visit[x][y] = true;
            ans++;
        }

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny] || arr[nx][ny] == 1) {
                continue;
            }

            clean(nx, ny, dir);
            return;
        }

        int backDir = (dir + 2) % 4;
        int backX = x + dx[backDir];
        int backY = y + dy[backDir];

        if (backX < 0 || backY < 0 || backX >= n || backY >= m || arr[backX][backY] == 1) {
            return;
        } else {
            clean(backX, backY, dir);
        }
    }
}