package Programmers.level2;

import java.util.ArrayList;
import java.util.Stack;

public class 짝지어제거하기 {
    //stack 이용하기
    public int solution(String s)
    {
        Stack stack = new Stack<>();

        for(char current : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().equals(current)){
                stack.pop();
            } else {
                stack.push(current);
            }
        }


        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        짝지어제거하기 test = new 짝지어제거하기();
        System.out.println(test.solution("baabaa"));
    }

}
