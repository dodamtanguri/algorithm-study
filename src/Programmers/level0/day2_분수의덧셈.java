package Programmers.level0;

import java.util.Arrays;

public class day2_분수의덧셈 {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];
        answer[0] = (denum1 * num2) + (denum2 * num1);
        answer[1] = num1 * num2;

        int target = gdc(answer[0], answer[1]);
        for(int i = 0; i < 2; i++) {
            answer[i] /= target;
        }
        return answer;
    }

    public static int gdc(int a, int b) {

        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        day2_분수의덧셈 test = new day2_분수의덧셈();
        System.out.println(Arrays.toString(test.solution(1, 2, 3, 4)));
    }

}
