package CodePlus.BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {
    static int a, b = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            sum += a;
        }
        Arrays.sort(arr);
        for (int i = 0; i < 9; i++) {
            for (int k = i + 1; k < 9; k++) {
                if (sum - arr[i] - arr[k] == 100) {
                    a = arr[i];
                    b = arr[k];
                }
            }
        }

        Arrays.stream(arr).forEach(ans -> {
            if(ans == a || ans == b) {
                return;
            }
            System.out.println(ans);
        });

    }

}


