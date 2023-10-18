package autoever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class temp{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] score = new int[n + 1];
        long[] sum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + score[i];
        }
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            double average = (double) (sum[b] - sum[a-1]) / (b - a + 1);
            BigDecimal bd = new BigDecimal(Double.toString(average));

            bd = bd.setScale(2, RoundingMode.HALF_UP);
            System.out.println(bd);

        }

    }
}
