package GoormLevel.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수판별 {
    public static String isPrime(int num) {
        String answer = "True";
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                answer = "False";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputData = Integer.parseInt(br.readLine());
        System.out.println(isPrime(inputData));
    }
}
