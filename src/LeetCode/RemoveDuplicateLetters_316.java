package LeetCode;

import java.util.Stack;
import java.util.StringTokenizer;

public class RemoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(target); }
            //stack 에 없는 경우 비교
            if(!stack.contains(target))  {
                char temp = stack.peek();
                if(temp > target) {
                    stack.pop();
                    stack.push(target);
                } else {
                    stack.push(target);
                }

            }

        }
        char[] ans = new char[stack.size()];
        int k = 0;
        while (!stack.isEmpty()) {
            ans[k++] = stack.pop();
        }

        return String.copyValueOf(ans);

    }

    public static void main(String[] args) {
        String s = "bcabc";
        RemoveDuplicateLetters_316 removeDuplicateLetters316 = new RemoveDuplicateLetters_316();
        System.out.println(removeDuplicateLetters316.removeDuplicateLetters(s));
    }
}
