package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10829 {
    static void binary(long n){
        if(n <= 1) {
            System.out.print(1);
        } else {
            binary(n / 2);
            System.out.print(n % 2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        binary(n);

        br.close();
    }
}
