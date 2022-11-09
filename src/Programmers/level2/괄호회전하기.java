package Programmers.level2;

import java.util.Stack;

public class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        int cnt = s.length();
        for (int i = 0; i < s.length(); i++) { // 문자열의 길이만큼 반복문
            StringBuilder sb = new StringBuilder(s);
            String tempStr = sb.substring(0,i);
            sb.delete(0,i); //앞에 문자 제거
           sb.append(tempStr); //제거된 문자 뒤에 추가
            System.out.println("[괄호회전하기]" + sb.toString());
            if(isCheck(sb)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isCheck(StringBuilder sb) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < sb.length(); i++) {
            int tempSbLength = sb.length();
            System.out.println(tempSbLength);
            if (stack.isEmpty()) { //stack이 ㅇ비어잇을경우 문자열 삽입
                stack.push(sb.charAt(i));
                System.out.println("[Stack]"+ stack);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        괄호회전하기 test = new 괄호회전하기();
        System.out.println(test.solution("[](){}"));
    }
}
