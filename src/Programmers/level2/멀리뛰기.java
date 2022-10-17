package Programmers.level2;

public class 멀리뛰기 {
    public long solution(int n) {

        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n] % 1234567;
    }

    public static void main(String[] args) {
        멀리뛰기 test = new 멀리뛰기();
        System.out.println(test.solution(1));
    }
}
