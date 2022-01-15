package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225 {
    static int n, k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= k; i++) {
            dp[1][i] = i;
        }


        for (int i = 2; i < n + 1; i++) {
            for (int m = 2; m < k + 1; m++) {
                dp[i][m] = (dp[i][m - 1] + dp[i - 1][m]) % 1000000000;
            }
        }
        System.out.println(dp[n][k]);
    }
}
