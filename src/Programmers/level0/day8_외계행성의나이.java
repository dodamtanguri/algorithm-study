package Programmers.level0;

import java.util.ArrayList;

public class day8_외계행성의나이 {
    public String solution(int age) {
        String answer = "";
        String temp = String.valueOf(age);
        for(int i = 0; i < temp.length(); i++) {
            answer += (char)(Integer.parseInt(String.valueOf(temp.charAt(i))) + 97);
        }
        return answer;
    }

    public static void main(String[] args) {
        day8_외계행성의나이 test = new day8_외계행성의나이();
        System.out.println(test.solution(23));
    }
}
