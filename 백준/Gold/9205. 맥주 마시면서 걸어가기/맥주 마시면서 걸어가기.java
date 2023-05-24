import java.util.*;

public class Main {
    static class Point {
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
        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            n = sc.nextInt();
            arr = new Point[n+2];
            for(int j=0; j<n+2; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[j] = new Point(x, y);
            }
            BFS();
        }
    }

    public static void BFS() {
        Queue<Point> q = new LinkedList<>();
        visit = new boolean[n+2];
        visit[0] = true;
        q.add(arr[0]);

        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.equals(arr[n+1])) {
                System.out.println("happy");
                return;
            }

            for(int i=1; i<n+2; i++) {
                if(!visit[i] && Math.abs(cur.x-arr[i].x)+Math.abs(cur.y-arr[i].y) <= 1000) {
                    visit[i] = true;
                    q.add(arr[i]);
                }
            }
        }
        System.out.println("sad");
    }
}
