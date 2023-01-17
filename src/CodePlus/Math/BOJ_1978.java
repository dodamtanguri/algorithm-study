package CodePlus.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(isPrime(Integer.parseInt(st.nextToken()))) {
                cnt++;
            }
        }

        System.out.println(cnt);


    }

    private static boolean isPrime(int x) {

        if(x < 2) {
            return false;
        }
        for(int i = 2; i * i <= x; i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
