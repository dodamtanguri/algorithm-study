package Programmers.level0;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class day10_배열회전시키기 {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];

        if (direction.equals("right")) {
            answer[0] = numbers[numbers.length - 1];
            for (int i = 0; i < numbers.length - 1; i++) {
                answer[i + 1] = numbers[i];
            }
        } else {
            for (int i = 1; i < numbers.length; i++) {
                answer[i - 1] = numbers[i];
            }
            answer[numbers.length - 1] = numbers[0];
        }

        return answer;
    }

    public static void main(String[] args) {
        day10_배열회전시키기 test = new day10_배열회전시키기();
        System.out.println(Arrays.toString(test.solution(new int[]{1, 2, 3}, "right")));
    }
}

