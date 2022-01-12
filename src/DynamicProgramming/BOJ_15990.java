package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15990 {
    static int t;
    static long[][] dp;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp = new long[100005][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            //1로 끝나는 수
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            //2로 끝나는 수
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
            //3으로 끝나는 수
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009);
        }
    }
}
