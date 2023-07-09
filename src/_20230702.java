import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class _20230702 {
    private static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            //입력값의 맨마지막 0 0
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];

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

    private static void dfs(int[][] map, int x, int y, int w, int h) {
        //중복카운트 방지
        map[x][y] = 0;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 1) {
                dfs(map, nx, ny, w, h);
            }

        }

    }
}
