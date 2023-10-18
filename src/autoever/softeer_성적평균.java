package autoever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class softeer_성적평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. N(학생수) 과 K(구간수) 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        //2. 각 학생들의 성적표 배열로 삽입
        int[] target = new int[n + 1];
        //3. 누적 합계 계산
        long[] sum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            target[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + target[i];
        }

        //3. K 번 만큼 성적 평균 구한 후 출력
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            double average = (double) (sum[b] - sum[a - 1]) / (b - a + 1);
            BigDecimal bd = new BigDecimal(Double.toString(average));
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            System.out.println(bd);
        }

    }
}
