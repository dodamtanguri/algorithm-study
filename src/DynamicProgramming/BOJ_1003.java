package DynamicProgramming;

import java.io.*;

public class BOJ_1003 {
    static int t;
    static int[][] dp;

    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;

        for(int i = 2; i <= 40 ; i++) {
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }
        for(int i = 0; i < t; i++) {
            int temp = Integer.parseInt(br.readLine());
            System.out.println(dp[temp][0] + " " + dp[temp][1]);
        }
    }
}
