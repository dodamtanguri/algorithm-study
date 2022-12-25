package Programmers.level0;

import java.util.Arrays;

public class day6_짝수홀수개수 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        answer[0] = (int) Arrays.stream(num_list).filter(i -> i % 2 == 0).count();
        answer[1] = (int) Arrays.stream(num_list).filter(i -> i % 2 != 0).count();
        return answer;
    }

    public static void main(String[] args) {
        day6_짝수홀수개수 test = new day6_짝수홀수개수();
        System.out.println(Arrays.toString(test.solution(new int[]{1, 2, 3, 4, 5})));
    }
}

