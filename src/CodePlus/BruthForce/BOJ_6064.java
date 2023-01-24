package CodePlus.BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        while (t-- > 0) {
            String[] temp = br.readLine().split(" ");
            int m = Integer.valueOf(temp[0]);
            int n = Integer.valueOf(temp[1]);
            int x = Integer.valueOf(temp[2])-1;
            int y = Integer.valueOf(temp[3]) -1;
            boolean check = false;
            for(int k = x; k < (n * m); k+=m) {
                if(k % n == y) {
                    System.out.println(k + 1);
                    check = true;
                    break;
                }
            }
            if(!check) {
                System.out.println(-1);
            }
        }
    }
}
