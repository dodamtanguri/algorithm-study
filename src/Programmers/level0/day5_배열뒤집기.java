package Programmers.level0;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day5_배열뒤집기 {
    public int[] solution(int[] num_list) {
        int [] answer = new int[num_list.length];
        for(int i = num_list.length-1, j = 0; i >= 0; i--, j++) {
            answer[j] = num_list[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        day5_배열뒤집기 test = new day5_배열뒤집기();
        System.out.println(Arrays.toString(test.solution(new int[]{1, 2, 3, 4, 5})));
    }
}
