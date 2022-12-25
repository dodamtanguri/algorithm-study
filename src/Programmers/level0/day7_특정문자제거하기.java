package Programmers.level0;

import datastructure.temp;

import java.util.stream.Stream;

public class day7_특정문자제거하기 {
    public String solution(String my_string, String letter) {

            return my_string.replaceAll(letter,"");
    }

    public static void main(String[] args) {
        day7_특정문자제거하기 test = new day7_특정문자제거하기();
        System.out.println(test.solution("abcdef","f"));
    }
}
