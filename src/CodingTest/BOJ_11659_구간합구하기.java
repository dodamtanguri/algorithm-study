package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dataCnt = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());


        int[] s = new int[dataCnt + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= dataCnt; i++) {
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < question; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(s[b]-s[a-1]);
        }


    }
}