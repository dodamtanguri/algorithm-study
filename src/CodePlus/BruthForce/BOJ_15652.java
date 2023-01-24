package CodePlus.BruthForce;

import java.util.Scanner;

public class BOJ_15652 {
    //중복 가능 => 같은 수 여러번 가능
    //수열은 비내림차순
    static int[] arr = new int[10];
    static boolean[] c = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    //여기서 start는 이전에 왔던 수인 i가 다시 올 수 있음 3 -> 3 가능
    static void func(int index, int start, int n, int m) {
        if(index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]);
                if (i != m - 1) sb.append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i <= n; i++){
            c[i] = true;
            arr[index] = i;
            func(index+1, i,  n, m);
            c[i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        func(0, 1, n, m);
        System.out.println(sb.toString());
    }
}
