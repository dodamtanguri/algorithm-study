package Programmers.level0;

public class day6_문자반복출력하기 {
    public String solution(String my_string, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= my_string.length() - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                sb.append(my_string.charAt(i));
            }
        }
            return sb.toString();
    }
}