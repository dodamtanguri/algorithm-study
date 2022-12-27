package Programmers.level0;

import java.util.HashMap;
import java.util.Map;

public class day9_가위바위보 {
    public String solution(String rsp) {
        String answer = "";
        Map<String, String> temp = new HashMap<>();
        temp.put("2","0");
        temp.put("0","5");
        temp.put("5","2");

        for(int i = 0; i < rsp.length(); i++) {
            answer += temp.get(String.valueOf(rsp.charAt(i)));
        }

        return answer;
    }

    public static void main(String[] args) {
        day9_가위바위보 test = new day9_가위바위보();
        System.out.println(test.solution("205"));
    }
}
