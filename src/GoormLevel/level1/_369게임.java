package GoormLevel.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _369게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        int count = 0;
        for(int i = 1; i < n; i++) {
            String str = String.valueOf(i);
            for(int k = 0; k < str.length(); k++) {
                char check = str.charAt(k);
                if(check == '3'|| check =='6'||check =='9' ) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
