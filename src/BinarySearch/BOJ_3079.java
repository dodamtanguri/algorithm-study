package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3079 {
    static int n, m;
    static long left,right;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 입국심사대
        m = Integer.parseInt(st.nextToken()); // 상근이 친구 수
        time = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            time[i] = Integer.parseInt(br.readLine());
            right = Math.max(right,time[i]);
        }





    }
    static void check(int n, int m) {
        left = 0;
        right = right * m;
    }
}
