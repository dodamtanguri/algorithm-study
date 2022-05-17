package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    //연산자끼워넣기
    //https://www.acmicpc.net/problem/14888
    static int n, max, min;
    //order -> 어떤 연산자를 순서로 기록했는지...
    static int[] nums, operators, order;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    //완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업이 필요
    //피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2) {
        int value = nums[1];
        for (int i = 1; i <= n - 1; i++) {
            if (operator == 1)
                return operand1 + operand2;
            if (operator == 2)
                return operand1 - operand2;
            if (operator == 3)
                return operand1 * operand2;
            if (operator == 4)
                return operand1 / operand2;

        }
        return value;
    }

    static void func(int k, int value) {
        if (k == n) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            //완성된 식이 없다면..?
        } else {
            for (int i = 1; i <= 4; i++) {
                if (operators[i] >= 1) {
                    operators[i]--;
                    order[k] = i;
                    func(k + 1, calculator(value, i, nums[k + 1]));
                    operators[i]++;
                    order[k] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        operators = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        order = new int[n + 1];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }
}
