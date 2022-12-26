package Programmers.level0;

import java.util.ArrayList;


public class day8_배열자르기 {
    public int[] solution(int[] numbers, int num1, int num2) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = num1; i <= num2; i++) {
           answer.add(numbers[i]);
        }
       int[] temp = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            temp[i] = answer.get(i);
        }

        return temp;
    }
}
