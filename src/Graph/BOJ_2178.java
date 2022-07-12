package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    //상하좌우를 탐색하기 위한 배열선언하기
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] a;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        visited = new boolean[n][m];

        //2차ㅏ원 행렬에 담기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            //각각의 수들은 붙어서 입력으로 주어진다고했으니까 String 으로 주어지는걸 알 수 있음
            String line = st.nextToken();
            //line으로 주어진것들은 잘라서 하나씩 배열에 집어넣어줌
            for (int j = 0; i < m; j++) {
                a[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0, 0);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {

            }
        }
    }
}
