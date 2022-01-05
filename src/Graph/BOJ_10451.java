package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_10451 {
    static int testCase, n, cnt;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static  BufferedWriter bw;
    static  BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            n = Integer.parseInt(br.readLine());
            adj = new ArrayList[n + 1];
            //리스트 초기화
            for (int k = 1; k <= n; k++) {
                adj[k] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int k = 1; k <= n; k++) {
                int a = Integer.parseInt(st.nextToken());
                adj[k].add(a);
                adj[a].add(k);
            }
            visited = new boolean[n + 1];
            cnt = 0;
            for(int k = 1; k <= n; k++) {
                if(!visited[k]) {
                    visited[k] = true;
                    DFS(k);
                    cnt++;
                }
            }
            bw.write(cnt+"\n");
        }//testCase loop end
        bw.flush();
        bw.close();
        br.close();
    }

    private static void DFS(int k) {
        for(int y : adj[k]) {
            if(!visited[y]) {
                visited[y] = true;
                DFS(y);
            }
        }
    }

}
