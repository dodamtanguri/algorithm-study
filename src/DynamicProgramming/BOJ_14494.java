package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14494 {
    static int n, m;
    static long[][] dp;

    public static long fibo(int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (n == 1 && m == 1) return 1;
        if(dp[n][m] != -1) return dp[n][m];
        dp[n][m] = (fibo(n, m - 1) + fibo(n - 1, m) + fibo(n - 1, m - 1)) % 1000000007;
        return dp[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new long[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            for(int k = 1; k <= m; k++) {
                dp[i][k] = -1;
            }
        }
        System.out.println((fibo(n,m))%1000000007);
    }
}
