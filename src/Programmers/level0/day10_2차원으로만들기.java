package Programmers.level0;

import java.util.Arrays;

public class day10_2차원으로만들기 {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        for (int i = 0; i < num_list.length / n; i++) {
            for (int k = 0; k < n; k++) {
                answer[i][k] = num_list[i * n + k];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        day10_2차원으로만들기 temp = new day10_2차원으로만들기();
        System.out.println(Arrays.deepToString(temp.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2)));
    }
}
