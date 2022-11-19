package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986_나머지합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] s = new long[n];
        long[] arr = new long[m];
        long answer = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n; i++) {
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());

        }

        for(int i = 0; i < n; i++) {
            int remainder = (int)(s[i] % m);
            if(remainder == 0) {
            answer++;
            }
            arr[remainder]++;
        }

        for(int i = 0; i < m; i++) {
            if(arr[i] > 1) {
                answer = answer + (arr[i] * (arr[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}
