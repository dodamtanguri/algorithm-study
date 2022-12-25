package Programmers.level0;

import java.io.FilterOutputStream;
import java.util.Arrays;
//Intstream rangeClosed(0,n)
public class day7_짝수의합 {
    public int solution(int n) {
        int answer = 0;
        int[] temp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            temp[i] = i;
        }
       return Arrays.stream(temp).filter(i -> i % 2 == 0).sum();
    }

    public static void main(String[] args) {
        day7_짝수의합 test = new day7_짝수의합();
        System.out.println(test.solution(10));
    }
}
