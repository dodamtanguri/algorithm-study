package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 2차원 배열의 크기
        int cnt = Integer.parseInt(st.nextToken()); // 구갑합의 질의 개수

        int[][] arr = new int[n + 1][n + 1];

        //이차원 배열 셋팅
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //구간합 구하기
        int[][] D = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n; k++) {
                D[i][k] = D[i][k-1] + D[i-1][k] - D[i-1][k-1] + arr[i][k];
            }
        }

        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

           int result = D[c][d] - D[a-1][d] - D[c][b-1] + D[a-1][b-1];

            System.out.println(result);
        }

    }
}
