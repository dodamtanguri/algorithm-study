package CodePlus.BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
    static boolean[] broken = new boolean[10];//고장난 버튼일 경우 true 정상 버튼 : false

    //이동 할 수 있는지 없는 확인하는 메소드
    //c로 이동이 가능 하면 c의 숫자의 갯수 return, 이동이 불가능 하면 0을 리턴해줌.
    static int possible(int c) {
        if (c == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (c > 0) {
            if(broken[c % 10]){
                return 0;
            }
            len++;
            c/=10;
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //목표로하는 채널
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            broken[temp] = true; // 고장난 버튼 확인
        }
    //정답의 초기값 설정
        int ans = n - 100;
        if(ans < 0) {
            ans = -ans;
        }
        for(int i = 0; i < 1000000; i++) {
            int c = i;
            int len = possible(c);
            if(len > 0) {
                int press = c - n;
                if(press < 0) {
                    press = -press;
                }
                if(ans > len + press) {
                    ans = len + press;
                }
            }
        }

        System.out.println(ans);

    }

}
