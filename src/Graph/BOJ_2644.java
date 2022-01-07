package Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static int n, m;
    static int target1, target2;
    static int[] answer;
    static int[][] adj;
    static StringTokenizer st;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        adj = new int[n + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = adj[b][a] = 1;
        }


        answer = new int[n + 1];
        BFS(target1);
        System.out.println(answer[target2]);

    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            answer[i] = -1;
        }
        queue.add(start);
        answer[start] = 0;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int y = 1; y<= n; y++) {
                if (adj[v][y] == 0) continue;
                if (answer[y] != -1) continue;
                queue.add(y);
                answer[y] = answer[v] + 1;
            }
        }


    }

}
