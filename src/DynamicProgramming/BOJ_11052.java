package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
    static int n;
    static BufferedReader br;
    static StringTokenizer st;
    static int[] dp, price;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        price = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                dp[i] = Math.max(dp[i], dp[i - k] + price[k]);
            }
        }
        System.out.println(dp[n]);
    }

}

