package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
    static int n, ans;
    static int[] col;

    static void func(int row) {
        if (row == n + 1) {
            if (validity_check())
                ans++;
        } else {
            for (int i = 1; i <= n; i++) {
                col[row] = i;
                func(row + 1);
                col[row] = 0;
            }
        }

    }

    private static boolean validity_check() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (attacable(i, col[i], j, col[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean attacable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true; // Q이 같은 열에 잇다는 건 공격관계라는 소리
        if(r1 - c1 == r2 - c2) return true; //왼쪽 위
        if(r1 + c1 == r2 + c2) return true; //오른쪽 위
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new int[n + 1];
        func(1);
        System.out.println(ans);
    }
}
