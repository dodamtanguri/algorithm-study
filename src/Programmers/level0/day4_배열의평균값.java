package Programmers.level0;

import java.util.Arrays;

public class day4_배열의평균값 {
    public double solution(int[] numbers) {

        return (double) Arrays.stream(numbers).average().orElse(0);
    }

    public static void main(String[] args) {
        day4_배열의평균값 test = new day4_배열의평균값();
        System.out.println(test.solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
