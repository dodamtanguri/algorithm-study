package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2312 {
    //수 복원하기

    static int test, n;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test = Integer.parseInt(br.readLine());
        while (test --> 0){
            n = Integer.parseInt(br.readLine());
            isPrime(n);
            for(int i = 2; i <= n; i++) {
                if(!prime[i]) { //소수일 경우
                    int cnt = 0;
                    //각 인수와 그 인수가 곱해진 횟수를 한 줄씩 출력하기 때문에
                    while (n % i == 0) {
                        n /= i;
                        cnt++;
                    }
                    if(cnt == 0) continue;
                    System.out.println(i +" "+ cnt);

                }
            }
        }

    }

    private static void isPrime(int n) {
        prime = new boolean[n + 1];
        //배열은 할당할 때 초기값으로 셋팅됨 boolean 은 false로
        prime[0] = prime[1] = true; //  0 과 1은 소수가 아님
        for(int i = 2; i <= n; i++) {
            if(!prime[i]) { // 소수일 경우
                for(int j = i * 2; j <= n; j += i) { //해당 소수의 배수들을 true로 만들어줌
                    prime[j] = true; // 소수가 아님
                }
            }

        }
    }
}
