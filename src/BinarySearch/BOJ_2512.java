package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_2512 {
    static int sum = 0;
    static int m, left, right, mid;
    static StringTokenizer st;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //지방의 수
        int n = Integer.parseInt(br.readLine());
        //각 지방의 예산
        int[] budget = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
        }
        Arrays.sort(budget);
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        if (sum <= m) {
            System.out.println(budget[n - 1]);
        } else {
            left = 0;
            right = budget[n - 1];
            while (left <= right) {
                int current = 0;
                mid = (left + right) / 2;
                for (int i = 0; i < n; i++) {
                    current += Math.min(budget[i], mid);
                }
                if (current <= m) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(right);
        }

    }
}
