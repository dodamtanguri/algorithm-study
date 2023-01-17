package CodePlus.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1929 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

       boolean[] check = new boolean[m + 1];
        check[0] = check[1] = true;
        for (int i = 2; i * i <= m; i++) {
            if (check[i] == true) {
                continue;
            }

            for (int k = i + i; k <= m; k += i) {
                check[k] = true;
            }
        }
        for(int i = n; i <= m; i++) {
            if(check[i] == false) {
                System.out.println(i);
            }
    }
}
}
