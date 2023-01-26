package CodePlus.BruthForce;

import java.util.Scanner;

public class BOJ_9095 {
    static int func(int cnt, int sum, int goal) {
        //불가능한 경우 1. 절대로 답을 구할 수 없는 경우  = Sum이 N을 넘어가는 경우 재귀함수 호출할 필요가 없어짐
        if (sum > goal) return 0;
        //정답을 찾은 경우 => 정답을 1개 찾은 것
        if (sum == goal) return 1;
        int now = 0;
        for (int i = 1; i <= 3; i++) {
            now += func(cnt + 1, sum + i, goal);
        }
        return now;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println(func(0,0, sc.nextInt()));
        }
    }
}
