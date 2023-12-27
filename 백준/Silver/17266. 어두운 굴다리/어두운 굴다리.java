import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // Length of the street
        int M = sc.nextInt(); // Number of streetlights

        int[] lights = new int[M];
        for (int i = 0; i < M; i++) {
            lights[i] = sc.nextInt();
        }

        int answer = solve(N, lights);
        System.out.println(answer);
    }

    private static int solve(int N, int[] lights) {
        int left = 0, right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isEnough(mid, N, lights)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isEnough(int height, int N, int[] lights) {
        int last = 0;
        for (int light : lights) {
            if (light - height > last) {
                return false;
            }
            last = light + height;
        }
        return last >= N;
    }
}
