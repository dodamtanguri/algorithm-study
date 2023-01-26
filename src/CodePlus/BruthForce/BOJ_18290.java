package CodePlus.BruthForce;

public class BOJ_18290 {
    static int[][] arr = new int[10][10];
    static boolean[][] c = new boolean[10][10];
    static int n, m, k;
    static int ans = Integer.MIN_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static void func (int cnt, int sum) {
        if(cnt == k) {
            if(ans < sum) ans = sum;
            return;
        }
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {

            }
        }
    }
}
