package BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {
    static int n, m, left, right;
    static int[] sangCard;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //상근이가 가지고 있는 card 수
        n = Integer.parseInt(br.readLine());

        //상근이가 가지고 있는 card
        sangCard = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sangCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sangCard);

        //확인해야하는 카드 수

        m = Integer.parseInt(br.readLine());
        //확인해야할 카드
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (binarySearch(temp)) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }
        bw.close();
        br.close();

    }

    private static boolean binarySearch(int temp) {
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sangCard[mid] < temp) {
                left = mid + 1;
            } else if (sangCard[mid] > temp) {
                right = mid - 1;
            } else {
                return true;
            }

        }
        return false;
    }
}
