package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {
    static int n, m;
    static ArrayList<Integer>[] a;
    static boolean[] visit;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = n - 1;
        parents = new int[n + 1];
        StringTokenizer st;
        //데이터를 담을 인접리스트
        a = new ArrayList[n + 1];
        //방문기록
        visit = new boolean[n + 1];
        //노드의 개수만큼 인접 리스트 초기화
        for (int i = 1; i < n + 1; i++) {
            a[i] = new ArrayList<Integer>();
        }
        //엣지의 개수만큼 데이터 삽입
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            //양방향에 데이터 삽입
            a[s].add(e);
            a[e].add(s);
        }

        DFS(1);

        for (int i = 2; i < n + 1; i++) {
            System.out.println(parents[i]);
        }

    }

    private static void DFS(int v) {

        visit[v] = true;
        for (int i : a[v]) {
            if (!visit[i]) {
                parents[i] = v;
                DFS(i);
            }
        }
    }
}
