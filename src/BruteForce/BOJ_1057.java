package BruteForce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1057 {
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        //토너먼트 참가자 수
        int n = Integer.parseInt(st.nextToken());
        //김지민 번호
        int k = Integer.parseInt(st.nextToken());
        //임한수 번호
        int l = Integer.parseInt(st.nextToken());
        //김지민과 임한수가 만날 라운드
        int round = 0;
        while (k != l) {
            k = k / 2 + k % 2;
            l = l / 2 + l % 2;
            round++;
        }
        System.out.println(round);
    }
}
