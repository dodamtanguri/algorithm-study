package CodePlus.BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
    static int[] t;
    static int[] p;
    static int n;
    static int ans = 0;

    static void func(int day, int sum) {
        //정답을 찾은 경우
        if (day == n+1) {
            if (ans < sum) ans = sum;
            return;
        }
        //불가능한 경우
        if (day > n+1) {
            return;
        }
        func(day + 1, sum);
        func(day + t[day], sum + p[day]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        t = new int[n+1] ;
        p = new int[n+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        func(1,0);
        System.out.println(ans);
    }
}
