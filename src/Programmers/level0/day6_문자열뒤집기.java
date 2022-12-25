package Programmers.level0;

public class day6_문자열뒤집기 {
    public String solution(String my_string) {
        String answer = "";
        char[] temp = my_string.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = my_string.length()-1; i >= 0; i--) {
            sb.append(temp[i]);
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        day6_문자열뒤집기 test = new day6_문자열뒤집기();
        System.out.println(test.solution("jaron"));
    }
}
