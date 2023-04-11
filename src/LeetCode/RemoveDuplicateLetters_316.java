package LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        //1. 빈도수 배열 만들기 >> 앞에 문자가 이미 들어가있는데 뒤에 탐색할
        int[] frequency = new int[26];
        //
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        Set<Character> selected = new HashSet<>();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // target 값의 빈도수를 1 감소시키고 시작
            char target = s.charAt(i);
            frequency[target - 'a']--;
            //이미 선택된 문자인 경우 스킵
            //이미 선택된 문자를 저장하고 문자열 s를 처음부터 순회 하면서 문자를 확인함.
            //c가 이미 selected에 들어있는 경우에는 스킵하고 아닌경우에는 selected에 추가하고 스택에도 추가하는 과정을 거침
            if (selected.contains(target)) {
                continue;
            }
            //스택이 비지 않았고, 스택의 최상위 문자보다 작으며, 추후에 나올 수 있는 문자의 경우
            while (!stack.isEmpty() && stack.peek() > target && frequency[stack.peek() - 'a'] > 0) {
                selected.remove(stack.pop());
            }
            //스택에 현재 문자 추가
            stack.push(target);
            selected.add(target);


        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        String s = "cbacdcbc";
        RemoveDuplicateLetters_316 removeDuplicateLetters316 = new RemoveDuplicateLetters_316();
        System.out.println(removeDuplicateLetters316.removeDuplicateLetters(s));
    }
}
