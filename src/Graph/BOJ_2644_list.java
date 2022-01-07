package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_list {
    static int n, m, target1, target2;
    static ArrayList<Integer>[] adj;
    static int[] dist;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
      BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        dist = new int[n + 1];
        BFS(target1);
        System.out.println(dist[target2]);

    }

    private static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dist[i] = -1;
        }
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            for(int y : adj[x]) {
                if(dist[y] != -1) continue; //이미 탐색한 점이면 무시
                q.add(y);
                dist[y] = dist[x] + 1;
            }
        }

    }

}
