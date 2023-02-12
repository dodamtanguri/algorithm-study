package CodePlus.DynamicProgramming;

import java.util.Scanner;

public class BOJ_11727 {
    static int[] d = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d[0] = 0;
        d[1] = 1;
        d[2] = 3;
        for(int i = 3; i <= n; i++) {
            d[i] = (d[i-1] + (d[i-2] * 2)) % 10007;
        }

        System.out.println(d[n]);

    }
}
