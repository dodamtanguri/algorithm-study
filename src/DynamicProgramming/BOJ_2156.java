package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
    static int n;
    static int[] dp;
    static int[] a;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = a[1];
        if (n > 1) {
            dp[2] = a[1] + a[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + a[i], dp[i - 3] + a[i - 1] + a[i]));
        }
        System.out.println(dp[n]);
    }
}
