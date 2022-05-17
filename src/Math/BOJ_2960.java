package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {
    static int n, k, cnt;
    static boolean[] isPrime;

    static int prime(int n, int k) {
        cnt = 0;
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (!isPrime[j])
                    continue;
                isPrime[j] = false;
                cnt++;
                if (cnt == k) return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        isPrime = new boolean[n + 1];
        System.out.println(prime(n, k));
    }
}
