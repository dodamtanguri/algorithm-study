package CodePlus.BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {
    static int[] arr = new int[10];
    static int[] index = new int[10];
    static boolean[] c = new boolean[10];

    static StringBuilder func(int num, int n, int m) {
        if (num == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(index[arr[i]]);
                if (i != m - 1) sb.append(' ');
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (c[i]) continue;
            c[i] = true;
            arr[num] = i;
            ans.append(func(num + 1, n, m));
            c[i] = false;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        index = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            index[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(index, 0, n);
        System.out.println(func(0, n, m));
    }
}
