package _2023.마이다스아이티;

import java.util.Stack;

public class Basic_3 {
    public String solution(String s) {

        if (s == null || s.length() == 0) {
            return "true";
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return "false";
            }
        }

        return stack.isEmpty() ? "TRUE" : "FALSE";
    }

}



