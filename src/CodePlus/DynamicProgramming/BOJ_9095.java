package CodePlus.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_9095 {
    static int[] d = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        d[0] = 1;
        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= 11; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int temp = Integer.parseInt(br.readLine());
            System.out.println(d[temp]);
        }
    }

}
