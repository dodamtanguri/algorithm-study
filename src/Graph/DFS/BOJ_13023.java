package Graph.DFS;

import javax.naming.PartialResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {
    //같은친구의관계가 2번이상 주어지지 않음
    //n = 노드, m = 엣지 개수
    //depth 확인해야함
    static int n, m;
    static ArrayList<Integer>[] a;
    static boolean visited[];
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = false;
        a = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        //인접리스트 초기화
        for (int i = 0; i < n + 1; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }
        for (int i = 0; i < n; i++) {
            DFS(i, 1);
            if (answer) break;
        }
        if (answer) System.out.println("1");
        else System.out.println("0");
    }

    private static void DFS(int current, int depth) {
        if (depth == 5 || answer) {
            answer = true;
            return;
        }
        visited[current] = true;
        for(int i : a[current]) {
            if(!visited[i]){
                DFS(i, depth + 1);
            }
        }
        visited[current] = false;
    }


}
