package CodePlus.BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static boolean[] check = new boolean[10]; // i를 사용했으면 true, 미사용 이면 false;
    //1~N 까지 수 중에서 앞에서 사용하지 않은 수를 관리해주기 위해서
    //수열을 저장
    static int[] arr = new int[10];
    static StringBuilder sb = new StringBuilder();
    public static void go(int index, int n, int m) {
        if (index == m) {
            for(int i = 0; i < m; i++){
                sb.append(arr[i]);
                if(i != m-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (check[i]) continue; // 앞에서 사용하지 않은 수를 찾는 것
            //수 i를 사용할 수 있다는 의미가 됨.
            check[i] = true;
            arr[index] = i;
            go(index + 1, n, m);
            //함수를 사용하기 전에 인덱스를 사용했다고 먼저 체크 해주기
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
       go(0, n, m);
        System.out.println(sb.toString());

    }
}
