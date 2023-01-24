package CodePlus.BruthForce;

import java.util.Scanner;

public class BOJ_15651 {
    static int[] arr = new int[10];
    static boolean[] c = new boolean[10];

    static StringBuilder func(int index, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]);
                if (i != m - 1) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            c[i] = true;
            arr[index] = i;
            ans.append(func(index + 1, n, m));
            c[i] = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(func(0,n,m));
    }
}
