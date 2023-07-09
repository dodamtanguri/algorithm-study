package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //목표 이모티콘 개수
        int n = sc.nextInt();
        // 이모티콘 개수와 클립보드에 저장된 이모티콘 개수를 기준으로 DP를 작성
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            //dp배열을 최대값으로 초기화
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        //초기 상태 큐에 삽입
        q.offer(new int[]{1, 0});
        dp[1][0] = 0;

        while (!q.isEmpty()) {
            // 큐에서 현재 상태 가져옴
            int[] current = q.poll();
            // 현재 상태의 화면, 클립보드, 연산 횟수를 가져옴
            int screen = current[0];
            int clipboard = current[1];
            int count = dp[screen][clipboard];
            if (screen == n) {
                System.out.println(count);
                break;
            }
            if (dp[screen][screen] > count + 1) {
                dp[screen][screen] = count + 1;
                q.offer(new int[]{screen, screen});
            }

            // 붙여넣기 연산
            int newScreen = screen + clipboard;
            int newClipboard = clipboard;
            if (newScreen <= n && dp[newScreen][newClipboard] > count + 1) {
                dp[newScreen][newClipboard] = count + 1;
                q.offer(new int[]{newScreen, newClipboard});
            }

            newScreen = screen - 1;
            newClipboard = clipboard;
            if (newScreen >= 0 && dp[newScreen][newClipboard] > count + 1) {
                dp[newScreen][newClipboard] = count + 1;
                q.offer(new int[]{newScreen, newClipboard});
            }
            sc.close();

        }
    }
}
