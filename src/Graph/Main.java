package Graph;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //지도 배열 선언
        int[][] maze = new int[N][M];
        //배열 채우기
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = row.charAt(j) - '0';
            }
        }
        //Queue 선언 BFS 실행
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        //방향 상하좌우
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        //큐가 빌때까지 실행
        while (!queue.isEmpty()) {
            //현재위치를 가져와서 처리하는 부분
            int[] current = queue.poll();
            int x = current[0]; //x좌표
            int y = current[1]; //y좌표
            //상하좌우로 이동할 수 있는지 확인 하고
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //다음 이동할 위치(nx,ny)가 미로의 범위를 벗어나거나, 벽(0)인 경우를 확인하는 부분
                //이경우 이동할 수 없으므로 다음 방향 검사를 하기 위해 continue 사용하여 현재 반복을 건너뛰고 다음 반복으로 넘어감.
                //nx < 0: nx가 0보다 작은 경우, 미로의 왼쪽 경계를 벗어난 것입니다.
                //ny < 0: ny가 0보다 작은 경우, 미로의 상단 경계를 벗어난 것입니다.
                //nx >= N: nx가 N보다 크거나 같은 경우, 미로의 오른쪽 경계를 벗어난 것입니다.
                //ny >= M: ny가 M보다 크거나 같은 경우, 미로의 하단 경계를 벗어난 것입니다.
                //maze[nx][ny] == 0: 미로의 해당 위치(nx, ny)가 벽(0)인 경우입니다.
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || maze[nx][ny] == 0) {
                    continue;
                }
                //이동 할 수 있는 위치라면  이동한 위치를 큐에 넣는 과정 진행
                if (maze[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny}); // 이후 BFS 과정을 통해서 이위치를 기준으로  다시 상하좌우 이동 가능한 위치를 찾을 수있음.
                    maze[nx][ny] = maze[x][y] + 1; //이동한 칸수 저장
                }
            }
        }

        System.out.println(maze[N - 1][M - 1]);
    }
}
