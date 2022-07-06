package Graph.DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1325 {
    static int n, m;
    static int[] result;
    static ArrayList<Integer>[] a;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new ArrayList[n + 1];
        result = new int[n + 1];
        visit = new boolean[n + 1];

        //노드의 갯수만큼 인접리스트 초기화
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        //엣지의 갯수만큼 데이터 삽입
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            //단방향
            a[s].add(e);
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visit, false);
            DFS(i);
        }
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void DFS(int c) {
        visit[c] = true;
        for (int node : a[c]) {
            if (!visit[node]) {
                result[node]++;
                DFS(node);
            }
        }
    }
}
