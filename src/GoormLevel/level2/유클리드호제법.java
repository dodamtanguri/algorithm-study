package GoormLevel.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유클리드호제법 {
    /**
     * @param a 큰수
     * @param b 작은수
     * @return 최대공약수
     */
    public static int gdc(int a, int b) {
        int r = a % b;
        //나머지가 0이면 작은 수가 최대공약수
        if (r == 0) {
            return b;
        } else {
            return gdc(b, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gdc(a,b));

    }
}
