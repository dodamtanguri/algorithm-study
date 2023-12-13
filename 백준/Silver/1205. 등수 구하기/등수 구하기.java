import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // Number of existing scores
        int newScore = sc.nextInt(); // New score
        int P = sc.nextInt(); // Maximum size of the leaderboard
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println(getRank(scores, newScore, P));
    }

    private static int getRank(int[] scores, int newScore, int P) {
        if (scores.length < P || newScore > scores[scores.length - 1]) {
            int rank = 1;
            for (int score : scores) {
                if (newScore < score) {
                    rank++;
                }
            }
            return rank;
        }
        return -1; // The new score doesn't fit in the leaderboard
    }
}
