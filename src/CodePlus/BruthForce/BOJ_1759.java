package CodePlus.BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static void func(int n, String[] alpha, String password, int index) {
        // 3. 정답을 찾은 경우
        if (n == password.length()) {
            if (check(password)) {
                System.out.println(password);
            }
            return;
        }

        if (index >= alpha.length) return;
        //1. 알파벳을 사용한 경우
        func(n, alpha, password + alpha[index], index + 1);
        //2. 알파벳을 사용하지 않은 경우
        func(n, alpha, password, index + 1);

    }

    private static boolean check(String password) {
        int ja = 0;
        int mo = 0;
        for (char x : password.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo += 1;
            } else {
                ja += 1;
            }
        }
        return ja >= 2 && mo >= 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String[] alphabet = new String[c];
        for (int i = 0; i < c; i++) {
            alphabet[i] = st.nextToken();
        }
        Arrays.sort(alphabet);
        func(n, alphabet, "", 0);
    }
}
