package Programmers.level2;

import datastructure.temp;

import java.util.stream.Stream;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int remove = 0; //제거된 0의 값
        int cnt = 0; // 변환횟수

        while (!s.equals("1")){
            int temp = s.length();
            s = s.replaceAll("0","");
            cnt ++;
            remove += (temp - s.length());
            s = Integer.toBinaryString(s.length());
        }
        return new int[] {cnt, remove};
    }

    public static void main(String[] args) {
        이진변환반복하기 test = new 이진변환반복하기();
        System.out.println(test.solution("110010101001"));
    }
}
