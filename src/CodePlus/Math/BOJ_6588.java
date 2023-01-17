package CodePlus.Math;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_6588 {
    static int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[MAX + 1];

        ArrayList<Integer> arr = new ArrayList<>();

        check[0] = check[1] = true;

        for(int i = 2; i * i <= MAX; i++) {
            if(check[i] == true) {
                continue;
            }
            arr.add(i);
            for(int k = i + i; k <= MAX; k+=i) {
                check[k] = true;
            }
        }
        while (true) {
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }
            for(int i = 1; i < arr.size(); i++) {
                int p = arr.get(i);
                if(check[n-p] == false) {
                    System.out.println(n + "=" + p + "+" + (n - p));
                    break;
                }
            }
        }
    }
}
