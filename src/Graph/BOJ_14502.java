package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
    static int N, M;
    static int[][] map; // 지도
    static int[][] temp; //
    static int[] dx = {-1, 0, 1, 0}; // 방향
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;


    public static void buildWall(int cnt) { //벽을 세우는 함수
        if (cnt == 3) {
            //바이러스를 퍼트려도 되는상황
            virusSpread();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { //0일경우 빈칸
                    map[i][j] = 1;
                    buildWall(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void virusSpread() {
        // 지도를 복사합니다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        // 바이러스를 퍼뜨립니다.
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = current[0] + dx[k];
                int ny = current[1] + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // 안전 영역의 크기를 구합니다.
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        result = Math.max(result, safeArea);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        buildWall(0);
        System.out.println(result);
    }


}
