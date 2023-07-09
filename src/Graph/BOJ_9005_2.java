package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9005_2 {
    static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static Point[] arr;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++) {
            n = sc.nextInt();
            arr = new Point[n+2];
            for(int k = 0; k < n+2; k++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[k] = new Point(x,y);
            }

            BFS();

        }


    }

    private static void BFS() {
        Queue<Point> q = new LinkedList<>();
        visit = new boolean[n + 2];
        //처음 시작 위치는 항상 방문된거니까 true 로 해놓기
        visit[0] = true;

        q.add(arr[0]);

        while (!q.isEmpty()) {
            Point current = q.poll();

            if(current.equals(arr[n+1])) {
                System.out.println("happy");
                return;
            }

            for(int i = 1; i < n+2; i++) {
                if(!visit[i] && Math.abs(current.x - arr[i].x) + Math.abs(current.y - arr[i].y) <- 1000) {
                    visit[i] = true;
                    q.add(arr[i]);
                }
            }
        }
        System.out.println("sad");
    }
}
