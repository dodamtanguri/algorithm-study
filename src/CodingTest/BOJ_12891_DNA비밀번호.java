package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {
    static int[] current;
    static int[] check;
    static int checkPwd;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken()); // 문자열의 크기
        int p = Integer.parseInt(st.nextToken()); // 부분문자열의 크기
        checkPwd = 0;
        char[] a = new char[s]; //문자열데이터
        a = br.readLine().toCharArray();

        check = new int[4]; //비밀번호 체크배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            if (check[i] == 0) {
                checkPwd++;
            }
        }
        result = 0;
        current = new int[4]; //현재상태를 나타내는 배열
        for (int i = 0; i < p; i++) {
            Add(a[i]);
        }
        if (checkPwd == 4) {
            result++;
        }

        for (int i = p; i < s; i++) {
            int temp = i - p;
            Add(a[i]);
            remove(a[temp]);

            if (checkPwd == 4) {
                result++;
            }
        }

        System.out.println(result);

    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                current[0]++;
                if (current[0] == check[0]) {
                    checkPwd++;
                }
                break;
            case 'C':
                current[1]++;
                if (current[1] == check[1]) {
                    checkPwd++;
                }
                break;
            case 'G':
                current[2]++;
                if (current[2] == check[2]) {
                    checkPwd++;
                }
                break;
            case 'T':
                current[3]++;
                if (current[3] == check[3]) {
                    checkPwd++;
                }
                break;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (current[0] == check[0]) {
                    checkPwd--;
                }
                current[0]--;
                break;
            case 'C':
                if (current[1] == check[1]) {
                    checkPwd--;
                }
                current[1]--;
                break;
            case 'G':
                if (current[2] == check[2]) {
                    checkPwd--;
                }
                current[2]--;
                break;
            case 'T':
                if (current[3] == check[3]) {
                    checkPwd--;
                }
                current[3]--;
                break;
        }
    }
}
