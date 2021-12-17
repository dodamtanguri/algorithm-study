package GoormLevel.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 완전수 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = a; i <= b; i++) {
            int temp = 0;
            for (int k = 1; k < i; k++) {
                if (i % k == 0) {
                    temp += k;
                }
            }
            if (i == temp) {
                System.out.print(temp+" ");
            }
        }
    }
}
