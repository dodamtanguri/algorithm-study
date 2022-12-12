package Programmers.level0;

import java.util.Arrays;

public class day3_중앙값구하기 {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);

        answer = array[(array.length/2)];

        return answer;
    }

    public static void main(String[] args) {
        day3_중앙값구하기 test = new day3_중앙값구하기();
        System.out.println(test.solution(new int[]{9, -1, 0}));
    }
}
