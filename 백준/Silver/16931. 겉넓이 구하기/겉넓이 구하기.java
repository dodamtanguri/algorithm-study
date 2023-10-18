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
        int total = 0;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                //현재셀 
                total += 6 * grid[i][j];
                //쌓인 블록들 사이에 숨겨진거 표면 계산
                
                if(grid[i][j]>1) {
                    total -= 2 * (grid[i][j]-1);
                }
                //왼쪽 셀에서 숨겨진거 찾는거 
                // Math.min(grid[i][j], grid[i-1][j]); >> 더 낮은 블럭의 표면을 찾는게. 
                if(i > 0) {
                    total -= 2 * Math.min(grid[i][j], grid[i-1][j]);
                }
                //위쪽 셀에서 숨겨진 표면 찾는거 
                if(j > 0) {
                    total -= 2 * Math.min(grid[i][j], grid[i][j-1]);
                }
               
            }
        }
        return total;
        
    }
}
