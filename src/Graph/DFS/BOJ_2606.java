package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static int n, m, ans;
    static ArrayList<Integer>[] a;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        a = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        //노드의 개수만큼 인접리스트 초기화
        for (int i = 1; i < n + 1; i++) {
            a[i] = new ArrayList<Integer>();
        }

        //엣지의 개수만큼 데이터 삽입
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }
        ans = 0;
        DFS(1);

        System.out.println(ans);

    }

     static void DFS(int i) {
        visit[i] = true;
        for (int k : a[i]) {
            if (!visit[k]) {
                ans++;
                DFS(k);
            }
        }

    }
}