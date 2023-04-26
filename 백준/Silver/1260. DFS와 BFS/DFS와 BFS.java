

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, v;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }
        //작은 수부터 탐색할 수 있도록 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }
        visited = new boolean[n + 1];
        DFS(v);
        bw.newLine();
        for(int i = 1; i <= n; i++){
            visited[i] = false;
        }
        BFS(v);
        bw.flush();
        bw.close();
    }

    static void DFS(int v) throws IOException {
        visited[v] = true;
        bw.write(v + " ");
        for (int i : adj[v]) {
            if (visited[i]) continue;
            DFS(i);
        }
    }

    static void BFS(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            bw.write(v + " ");
            for (int i : adj[v]) {
                if (visited[i]) continue;

                queue.add(i);
                visited[i] = true;
            }
        }
    }


}
