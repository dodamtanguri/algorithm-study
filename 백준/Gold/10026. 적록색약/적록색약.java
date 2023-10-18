import java.util.*;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        grid = new char[N][N];
        visited = new boolean[N][N];

        // 그리드 입력 받기
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int normalCnt = 0; // 적록색약이 아닌 사람이 구역 개수 세기
        int rgCnt = 0; // 적록색약인 사람이 구역 개수 세기

        // 적록색약이 아닌 사람의 구역 개수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    normalBFS(i, j);
                    normalCnt++;
                }
            }
        }

        // visited 배열 초기화
        visited = new boolean[N][N];

        // 적록색약인 사람의 구역 개수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    rgBFS(i, j);
                    rgCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + rgCnt);
        scanner.close();
    }

    // 적록색약이 아닌 사람의 BFS
    private static void normalBFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        char color = grid[x][y];
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny] && grid[nx][ny] == color) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    // 적록색약인 사람의 BFS
    private static void rgBFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        char color = grid[x][y];
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    if (color == 'R' || color == 'G') {
                        if (grid[nx][ny] == 'R' || grid[nx][ny] == 'G') {
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    } else {
                        if (grid[nx][ny] == color) {
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }

    // 좌표 유효성 체크
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
