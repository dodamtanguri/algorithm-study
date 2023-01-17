package CodePlus.Math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int g = GCD(a,b);
        int lcm = LCM(a, b, g);


        System.out.println(g);
        System.out.println(lcm);
    }

    public static int GCD(int a, int b) {
        if(b == 0) return a;
        else return GCD(b, a%b);
    }

    public static int LCM (int a, int b, int g) {
        return a * (b / g);
    }

}
