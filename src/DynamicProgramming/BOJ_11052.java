package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11052 {
    static String str;
    static BufferedReader br;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int size = str.length();
        dp = new long[size + 1];
        dp[0] = dp[1] = 1;

        if (str.charAt(0) == '0' || str.charAt(size - 1) == '0' && str.charAt(size - 2) != '1' && str.charAt(size - 2) != '2') {
            System.out.println("0");
        } else {
            for (int i = 2; i <= size; i++) {
                //마지막 한자리 수 -> 한글자일 경우
                int temp = Integer.parseInt(str.substring(i - 1, i));
                if (temp <= 9 && temp >= 1) {
                    dp[i] = dp[i - 1];
                }

                temp += Integer.parseInt(str.substring(i - 2, i - 1)) * 10; // 10의 자리수
                if (temp <= 26 && temp >= 10) {
                    dp[i] += dp[i - 2];
                }
                dp[i] %= 1000000;
            }
            System.out.println(dp[size]);
        }

    }

}

