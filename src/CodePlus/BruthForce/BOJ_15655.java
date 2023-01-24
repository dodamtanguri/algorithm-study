package CodePlus.BruthForce;
 
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15655 {
    //오름차순 및 중복 x
    static int[] arr = new int[10];
    static boolean[] c = new boolean[10];
    static int[] num = new int[10];
    static StringBuilder sb = new StringBuilder();

    static void func(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(num[arr[i]]);
                if (i != m - 1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < n; i ++) {
            if(c[i]) continue;
            c[i] = true; arr[index] = i;
            func(index+1,i+1, n, m);
            c[i]= false;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num, 0, n);
        func(0, 0, n, m);
        System.out.println(sb.toString());
    }
}
