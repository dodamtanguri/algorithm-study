package Programmers.level0;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class day8_진료순서정하기 {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        ArrayList<Integer> temp = new ArrayList<>();
        for(int val : emergency) {
            temp.add(val);
        }
        Collections.sort(temp, Collections.reverseOrder());
        for(int i = 0; i < answer.length; i++) {
            answer[i] = temp.indexOf(emergency[i]) + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        day8_진료순서정하기 test = new day8_진료순서정하기();
        System.out.println(Arrays.toString(test.solution(new int[]{56,73,1})));
    }
}
