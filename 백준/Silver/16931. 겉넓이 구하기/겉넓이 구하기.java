import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getSurfaceArea(grid));
    }

    public static int getSurfaceArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 현재 셀의 블록들에 대한 표면적
                totalArea += 6 * grid[i][j];

                // 현재 셀에 쌓인 블록들 사이의 숨겨진 표면
                if (grid[i][j] > 1) {
                    totalArea -= 2 * (grid[i][j] - 1);
                }

                // 왼쪽 셀로부터 숨겨진 표면
                if (i > 0) {
                    totalArea -= 2 * Math.min(grid[i][j], grid[i-1][j]);
                }

                // 위쪽 셀로부터 숨겨진 표면
                if (j > 0) {
                    totalArea -= 2 * Math.min(grid[i][j], grid[i][j-1]);
                }
            }
        }

        return totalArea;
    }
}