package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
    //(h개의 줄 만큼 map이 주어짐 1: 땅 0 :바다)
    private static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            //테스트케이스 입력값 끝
            if (w == 0 && h == 0) {
                break;
            }
            //지도생서
            int[][] map = new int[h][w];

            //첫번째 지도 셋팅
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //섬의 개수
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    //땅인경우
                    if (map[i][j] == 1) {
                        count++;
                        dfs(map, i, j, w, h);
                    }
                }
            }
            System.out.println(count);
        }
        br.close();
    }


    public static void dfs(int[][] map, int x, int y, int w, int h) {
        //방문한 육지 reset
        map[x][y] = 0;
        //동서남북 포함 대각선방향 4방향까지 총 8번 반복분 실행
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 1) {
                dfs(map, nx, ny, w, h); // 인접한 육지를 찾기 위해 재귀 호출
            }
        }
    }
}
