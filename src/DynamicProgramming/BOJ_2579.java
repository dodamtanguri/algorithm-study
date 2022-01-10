package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    static int n;
    static int[] stair;
    static int[][] dp;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stair = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n + 1][2];

        dp[1][1] = 0;
        dp[1][0] = stair[1];

        if (n >= 2) {
            dp[2][0] = stair[2];
            dp[2][1] = stair[1] + stair[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 2][0] + stair[i], dp[i - 2][1] + stair[i]);
            dp[i][1] = dp[i - 1][0] + stair[i];
        }

        System.out.println(Math.max(dp[n][0], dp[n][1]));

    }
}
