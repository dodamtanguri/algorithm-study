package GoormLevel.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열뒤집기 {
    public static String useStringBuffer(String str) {
        return (new StringBuffer(str)).reverse().toString();
    }
    public static String useLoop(String str) {
        String reverse = "";
        for(int i = str.length(); i > 0; i--) {
            reverse += str.substring(i-1, i);
        }
        return reverse;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(useLoop(input));
        System.out.println(useStringBuffer(input));
    }
}
