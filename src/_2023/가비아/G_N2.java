package _2023.가비아;

import java.util.Arrays;

public class G_N2 {
    public int solution(int[] dots, int[] lines) {
        int n = dots.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int len : lines) {
                int j = i + 1;
                while (j <= n && dots[j - 1] - dots[i] <= len) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                    j++;
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }


    public static void main(String[] args) {
        int[] dots = {1, 5, 8};
        int[] lines = {1, 3, 4, 6};

        int[] dots2 = {1, 3, 4, 6, 7, 10};
        int[] lines2 = {2, 2, 2, 2};


        G_N2 test = new G_N2();
        System.out.println(test.solution(dots, lines));
        System.out.println(test.solution(dots2, lines2));

    }
}

