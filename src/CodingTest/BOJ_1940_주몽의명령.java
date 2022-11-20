package CodingTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940_주몽의명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 재료의 개수
        int m = Integer.parseInt(br.readLine()); // 갑옷이 완성되는 번호의 합
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //오름차순으로 정렬
        Arrays.sort(arr);
        int cnt = 0;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            if (arr[start] + arr[end] < m) {
                start++;
            } else if (arr[start] + arr[end] > m) {
                end--;
            } else {
                cnt++;
                start++;
                end--;
            }
        }
        System.out.println(cnt);
    }
}
