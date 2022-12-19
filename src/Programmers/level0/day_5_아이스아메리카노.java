package Programmers.level0;

import java.util.Arrays;

public class day_5_아이스아메리카노 {
    public int[] solution(int money) {
        int[] answer = new int[2];
        answer[0] = money / 5500;
        answer[1] = money % 5500;
        return answer;
    }

    public static void main(String[] args) {
        day_5_아이스아메리카노 test = new day_5_아이스아메리카노();
        System.out.println(Arrays.toString(test.solution(15000)));
    }
}
