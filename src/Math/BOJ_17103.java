package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17103 {
    static boolean[] isPrime;
    public static boolean[] primeArr() {
       isPrime = new boolean[1000001];
       for(int i = 2; i <= 1000000; i++) {
           for(int j = i * 2; j <= 1000000; j+=i) {
               isPrime[j] = true;
           }
       }
       return isPrime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        isPrime = primeArr();
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int k = 2; k <= num/2; k++) {
                if (!isPrime[k] && !isPrime[num-k]) {
                    ans++;
                }
            }
            System.out.println(ans);
        }

    }
}
