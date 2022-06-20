package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {


    static int twoPointer(int[] arr, int n, int s) {
        int sum = 0, r = 0;
        int ans = n+1; //수열의 부분합 길이가 최소인거로 업데이트 해줄거
        for (int l = 1; l <= n; l++) {
            sum -= arr[l - 1];

            while (r + 1 <= n && sum < s) {
                r++;
                sum += arr[r];
            }
            if (sum >= s) {
                ans = Math.min(ans, r - l + 1);
            }
        }
        if (ans == n + 1) {
            ans = 0;
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(twoPointer(arr, n, s));
    }
}
