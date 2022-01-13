package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    static int n;
    static int[][] dp;
    static int[] price;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][3];
        price = new int[3];

        dp[0][0] = dp[0][1] = dp[0][2] = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < 3; k++) {
                price[k] = Integer.parseInt(st.nextToken());
            }
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + price[0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + price[1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + price[2];


        }

        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}
