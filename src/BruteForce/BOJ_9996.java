package BruteForce;

import apple.laf.JRSUIConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9996 {
    static int t;
    static String input;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        input = br.readLine();
        int star = input.indexOf('*');
        String left = input.substring(0, star);
        String right = input.substring(star + 1, input.length());
        int inputLength = input.length() - 1;

        for (int i = 0; i < t; i++) {
            String temp = br.readLine();
            if (temp.length() < inputLength) {
                System.out.println("NE");
            } else if (temp.substring(0, left.length()).equals(left) &&
                    temp.substring((temp.length() - right.length()), temp.length()).equals(right)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }


        }
    }
}




