package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2548 {
    static int n, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(check(arr));


    }

    private static int check(int[] arr) {
        if (arr.length == 1) return arr[0];
        if (arr.length % 2 == 0) {
            return arr[arr.length / 2 - 1];

        } else {
            return arr[arr.length / 2 + 1];
        }
    }
}
