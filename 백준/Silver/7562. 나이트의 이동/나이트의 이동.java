

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    //나이트는 시작 위치에서 출발해서 목표위치까지 최소한의 이동횟수로 도달 >> BFS 사용
    //시작위치에서 출발해서 모든 가능한 이동을 탐색하고, 목표 위치에 도달할때 까지 탐색을 반복해서 최소 이동 횟수 구함
    private static final int[][] directions = {
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 개수
        //TestCase가 0이 될때까지 로직 반복 
        while (T-- > 0) {
            int N = scanner.nextInt(); // 체스판의 크기
            int startX = scanner.nextInt(); // 시작 위치 x좌표
            int startY = scanner.nextInt(); // 시작 위치 y좌표
            int endX = scanner.nextInt(); // 목표 위치 x좌표
            int endY = scanner.nextInt(); // 목표 위치 y좌표

            int[][] board = new int[N][N]; // 체스판 초기화
            board[startX][startY] = 1; // 시작 위치 방문 표시

            int result = bfs(board, N, startX, startY, endX, endY); // BFS 호출

            System.out.println(result); // 최소 이동 횟수 출력
        }

        scanner.close();
    }

    private static int bfs(int[][] board, int N, int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY}); // 시작 위치 큐에 삽입

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll(); // 큐에서 현재 위치를 가져옴
            int curX = curPos[0];
            int curY = curPos[1];

            if (curX == endX && curY == endY) {
                return board[curX][curY] - 1; // 목표 위치에 도달했을 때의 이동 횟수를 반환
            }

            for (int[] dir : directions) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && board[nextX][nextY] == 0) {
                    queue.offer(new int[] {nextX, nextY}); // 다음 위치를 큐에 삽입
                    board[nextX][nextY] = board[curX][curY] + 1; // 다음 위치의 이동 횟수를 현재 위치 + 1로 갱신
                }
            }
        }

        return -1; // 목표 위치에 도달할 수 없는 경우
    }
}
