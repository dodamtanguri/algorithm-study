package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1545_평균구하기 {
    static int[] arr;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine()); // 시험을 본 과목의 개수
            arr = new int[n];
            int max = Integer.MIN_VALUE;
            int total = 0;
            double answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            //배열에 각 과목의 시험성적 담기
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
                total += arr[i];
            }
            answer = total * 100.0 / max / n;

            System.out.println(answer);


        } catch (IOException e) {
            e.getStackTrace();
        }


    }
}
