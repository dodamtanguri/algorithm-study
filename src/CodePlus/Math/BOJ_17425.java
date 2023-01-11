package CodePlus.Math;

import java.io.*;

public class BOJ_17425 {
    //한번만구해놓고 그 값을 재활용하는 방법으로 써야함

    public static void main(String[] args) throws IOException {

        // 시간복잡도가 o(TN)이라서 1000억초 가 넘어가서 시간초과로 실패뜸
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int testCase = Integer.parseInt(br.readLine());
//        for(int i = 0; i < testCase; i++) {
//            int target = Integer.parseInt(br.readLine());
//            long ans = 0;
//            for(int k = 1; k <= target; k++) {
//                ans += Math.abs(target / k) * k;
//            }
//            System.out.println(ans);
//        }
        // 한번 다 구해놓고 그 값을 재활용하기
        int MAX = 1000000;
        long[] d = new long[MAX + 1];
        //1. 1은 모든 약수의 합에 디폴트로 들어가니까 배열을 모두 1로 셋팅해줘야함
        for(int i = 1; i <= MAX; i++) {
            d[i] = 1;
        }
        //2. 약수의 합을 구해주면됨
        for(int i = 2; i <= MAX; i++) {
            for(int j = 1; i*j <= MAX; j++) {
                d[i*j] += i;
            }
        }

        long[] s = new long[MAX + 1];
        for(int i = 1; i<= MAX; i++) {
            s[i] = s[i-1] + d[i];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test --> 0 ) {
            int n = Integer.parseInt(br.readLine());
            bw.write(s[n] + "\n");
        }
        bw.flush();
    }
}
