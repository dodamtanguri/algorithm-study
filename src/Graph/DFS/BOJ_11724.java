package Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static int n, m;
    static ArrayList<Integer>[] a; //데이터를 저장할 인접리스트
    static boolean visited[]; //방문기록

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new ArrayList[n + 1];
        //방문기록 초기화
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            //인접리스트 초기화
            a[i] = new ArrayList<Integer>();
        }
        //방향이 없는 그래프이기 때문에 양쪽방향으로 에지를 모두 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
           int s = Integer.parseInt(st.nextToken());
           int e = Integer.parseInt(st.nextToken());

           // 양방향으로 엣지 저장
            a[s].add(e);
            a[e].add(s);
        }
        int answer = 0;

        //방문기록이 모두 true 일때까지 dfs 반복
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                answer++;
                DFS(i);
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int v) {
        //방문한 적이 있는 노드일 경우
        if(visited[v]) {
            return;
        }
        //방문하지 않은 노드일 경우
        visited[v] = true;
        for(int i : a[v]) {
            if(visited[i] == false) {
                DFS(i);
            }

        }


    }
}
