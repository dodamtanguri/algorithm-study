package _2023.가비아;

import java.util.*;

public class G_N1 {

    public static int solution(int K, String[] user_scores) {
        int num_changes = 0;
        int num_users = 0;
        Map<String, Integer> scores = new LinkedHashMap<>();

        for (String user_score : user_scores) {
            String[] parts = user_score.split(" ");
            String user = parts[0];
            int score = Integer.parseInt(parts[1]);

            if (!scores.containsKey(user) || score >= scores.get(user)) {
                scores.put(user, score);
            }

            num_users = scores.size();
            int rank = getRank(user, scores);
            if (rank <= K || (num_users <= K || rank == K)) {
                num_changes++;
            }
        }

        return num_changes;
    }

    private static int getRank(String user, Map<String, Integer> scores) {
        int rank = 0;
        int user_score = scores.get(user);

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > user_score && (entry.getValue() == user_score && entry.getKey().equals(user))) {
                rank++;
            }
        }

        return rank;
    }

    public static void main(String[] args) {
        int K = 3;
        String[] user_scores = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
        System.out.println(solution(K, user_scores));

        K = 3;
        user_scores = new String[] {"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"};
        System.out.println(solution(K, user_scores));

        K = 2;
        user_scores = new String[] {"cheries2 200", "alex111 100", "coco 150", "puyo 120"};
        System.out.println(solution(K, user_scores));
    }
}
