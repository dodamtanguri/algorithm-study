import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * N];
        boolean[] robots = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while (true) {
            step++;

            // Step 1: Rotate the belt and robots
            int lastBelt = belt[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
                if (i < N) {
                    robots[i] = robots[i - 1];
                }
            }
            belt[0] = lastBelt;
            robots[0] = false;
            robots[N - 1] = false;

            // Step 2: Move the robots
            for (int i = N - 2; i >= 0; i--) {
                if (robots[i] && !robots[i + 1] && belt[i + 1] > 0) {
                    robots[i + 1] = true;
                    robots[i] = false;
                    belt[i + 1]--;
                    if (i + 1 == N - 1) {
                        robots[N - 1] = false;
                    }
                }
            }

            // Step 3: Put a robot on the belt
            if (!robots[0] && belt[0] > 0) {
                robots[0] = true;
                belt[0]--;
            }

            // Step 4: Check the belt
            int count = 0;
            for (int i = 0; i < 2 * N; i++) {
                if (belt[i] == 0) count++;
            }

            if (count >= K) break;
        }

        System.out.println(step);
    }
}
