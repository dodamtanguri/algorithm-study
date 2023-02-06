package CodePlus.BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819 {
    static boolean next_permutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j--;
        }
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    static int calculation(int[] a) {
        int sum = 0;
        for (int i = 1; i < a.length; i++) {
            sum += Math.abs(a[i] - a[i-1]);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int max = 0;
        do {
            int temp = calculation(a);
            max = Math.max(max, temp);
        } while (next_permutation(a));

        System.out.println(max);

    }

}
