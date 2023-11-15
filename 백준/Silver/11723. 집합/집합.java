import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int set = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            int x;

            switch (command[0]) {
                case "add":
                    x = Integer.parseInt(command[1]);
                    set |= (1 << (x - 1));
                    break;
                case "remove":
                    x = Integer.parseInt(command[1]);
                    set &= ~(1 << (x - 1));
                    break;
                case "check":
                    x = Integer.parseInt(command[1]);
                    sb.append((set & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(command[1]);
                    set ^= (1 << (x - 1));
                    break;
                case "all":
                    set = (1 << 20) - 1;
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}
