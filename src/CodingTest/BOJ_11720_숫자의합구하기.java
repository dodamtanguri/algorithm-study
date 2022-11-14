package CodingTest;

import com.sun.tools.javac.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720_숫자의합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //숫자의 개수

        int answer = 0;
        char[] temp = br.readLine().toCharArray();

        for(int i = 0; i < temp.length; i++) {
            answer += Integer.parseInt(String.valueOf(temp[i]));
        }

        System.out.println(answer);
    }
}
