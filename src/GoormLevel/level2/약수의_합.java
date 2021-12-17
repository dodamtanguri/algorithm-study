package GoormLevel.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 약수의_합 {
    public static int sum(int num) {
        int answer = 1;
        for(int i = 2; i <= num; i++) {
            if(num % i == 0) {
                answer += i;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println(sum(input));
    }
}
