package CodePlus.BruthForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_15650 {
    //1 ~ N까지 자연수 중에서 중복없이 M개를 고른 수열을 모두 구하는 문제 (오름차순 조건 추가)
    static int[] arr = new int[10];


    static void func(int index, int selected, int n, int m) {
        if (selected == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]);
                if (i != m - 1) System.out.print(' ');
            }
            System.out.println();
            return;
        }
        if (index > n) return;
        arr[selected] = index;
        func(index + 1, selected + 1, n, m);
        arr[selected] = 0;
        func(index + 1, selected, n, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        func(1, 0, n, m);

    }
}
