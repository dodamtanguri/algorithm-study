package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    static int n, m;
    static int[] selected, used;
    static StringBuilder sb = new StringBuilder();

    static void func(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = selected[k-1] + 1; i <= n; i++) {
                if (used[i] == 1) continue;
                selected[k] = i;
                used[i] = 1;
                func(k + 1);
                selected[k] = 0;
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[n + 1];
        used = new int[n + 1];
        func(1);
        System.out.println(sb.toString());

    }
}
