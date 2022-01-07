package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    static int testCase, n;
    static int[] dp;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int k = 4; k < dp.length; k++) {
            dp[k] = dp[k - 3] + dp[k - 2] + dp[k - 1];
        }

        for(int i = 0; i < testCase; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }


    }
}
