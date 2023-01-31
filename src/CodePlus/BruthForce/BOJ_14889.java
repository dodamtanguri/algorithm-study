package CodePlus.BruthForce;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_14889 {
    static int n;
    static int[][] s;

    static int func(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
        if (index == n) {
            if (first.size() != n / 2) return -1;
            if (second.size() != n / 2) return -1;
            int t1 = 0;
            int t2 = 0;
            for (int i = 0; i < n / 2; i++) {
                for (int k = 0; k < n / 2; k++) {
                    if (i == k) continue;
                    t1 += s[first.get(i)][first.get(k)];
                    t2 += s[second.get(i)][second.get(k)];
                }
            }
            int hp = Math.abs(t1 - t2);
            return hp;
        }
        if (first.size() > n / 2) return -1;
        if (second.size() > n / 2) return -1;
        int ans = -1;
        first.add(index);
        int t1 = func(index + 1, first, second);
        if (ans == -1 || t1 != -1 && ans > t1) {
            ans = t1;
        }
        first.remove(first.size() - 1);

        second.add(index);
        int t2 = func(index + 1, first, second);
        if (ans == -1 || t2 != -1 && ans > t2) {
            ans = t2;
        }
        second.remove(second.size() - 1);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                s[i][k] = sc.nextInt();
            }
        }
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        System.out.println(func(0, first, second));
    }
}
