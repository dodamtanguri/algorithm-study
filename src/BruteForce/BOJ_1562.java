package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1562 {
    static int n, m;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    static void func(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            int start = selected[k-1];
            if(start == 0) start =1;
            for (int i = start; i <= n; i++) {
                selected[k] = i;
                func(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m + 1];
        func(1);

        System.out.println(sb.toString());

    }
}
