package Programmers.level0;

import java.util.*;

public class day3_최빈값구하기 {
    public int solution(int[] array) {
        int answer = 0;

        int[] index = new int[1000];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            index[array[i]]++;
        }

        for (int i = 0; i < index.length; i++) {
            if (max < index[i]) {
                max = index[i];
                answer = i;
            } else if (max == index[i]) {
                answer = -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        day3_최빈값구하기 test = new day3_최빈값구하기();
        System.out.println(test.solution(new int[]{1, 1, 2, 2}));
    }
}
