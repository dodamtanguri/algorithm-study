package CodePlus.Math;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_4375 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int temp = 0;
            for (int i = 1; i <= n; i++) {
                temp = temp * 10 + 1;
                temp %= n;
                if (temp == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}

