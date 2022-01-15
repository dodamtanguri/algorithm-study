package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236 {
    static int[] price;
    static int n, m, k,left,right;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        price = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(br.readLine());
            right += price[i];

        }

        left = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = check(mid, n, m);
            if (temp == -1 || temp == 0) left = mid + 1;
            if (temp == 1 || temp == 2) right = mid - 1;
        }
        System.out.println(left);

    }

    // 횟수 체크

    /**
     * @param mid 인출금액
     * @param n
     * @param m   인출 횟수
     * @return 0 : 인출횟수 초과
     * 1 : 인출횟수 일치
     * 2 : 인출횟수 미만
     * -1 : 인출금액 < 지출금액
     */
    private static int check(int mid, int n, int m) {
        int current = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (mid < price[i]) return -1;
            if (current < price[i]) {
                cnt++;
                current = mid;
                if (cnt > m) return 0;
            }
            current -= price[i];
        }
        return cnt == m ? 1 : 2;
    }
}
