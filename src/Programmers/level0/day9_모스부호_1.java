package Programmers.level0;


import java.util.HashMap;
import java.util.Map;

public class day9_모스부호_1 {
    public String solution(String letter) {
        Map<String, String> morse = new HashMap() {
            {
                put(".-", "a");
                put("-...", "b");
                put("-.-.", "c");
                put("-..", "d");
                put(".", "e");
                put("..-.", "f");
                put("--.", "g");
                put("....", "h");
                put("..", "i");
                put(".---", "j");
                put("-.-", "k");
                put(".-..", "l");
                put("--", "m");
                put("-.", "n");
                put("---", "o");
                put(".--.", "p");
                put("--.-", "q");
                put(".-.", "r");
                put("...", "s");
                put("-", "t");
                put("..-", "u");
                put("...-", "v");
                put(".--", "w");
                put("-..-", "x");
                put("-.--", "y");
                put("--..", "z");
            }
        };
        String answer = "";
        String[] temp = letter.split(" ");
        for (String arr : temp) {
            answer += morse.get(arr);
        }
        return answer;
    }
}
