package GoormLevel.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최단거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] arr = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int temp = 0;
        int answer  = Integer.MAX_VALUE;
        for(int k = input-1; k > 0; k--) {
            temp = arr[k] - arr[k-1];
            answer = Math.min(answer,temp);
        }
        System.out.println(answer);

    }
}
