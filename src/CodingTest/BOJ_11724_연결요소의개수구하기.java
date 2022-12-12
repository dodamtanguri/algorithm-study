package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수구하기 {
    static ArrayList<Integer>[] arr; // 인접리스트
    static boolean[] visited; // 방문배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드개수
        int m = Integer.parseInt(st.nextToken()); // 에지개수

        arr = new ArrayList[n + 1]; // 인접리스트 초기화
        visited = new boolean[n + 1]; //방문배열 초기화

        //우선 인접리스트에 연결된 리스트들을 초기화를해야함
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        //엣지의 개수만큼 데이터들 저장해주기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
    }

    private static void DFS(int v) {
        //한번 방문 했던 배열이면 걍 리턴
        if (visited[v]) {
            return;
        }
        //방문하지 않은 곳이면 true로 바꿔주고 그 인접한거 탐색해주려면 DFS 한 번 더 돌려야함 같은 depth 안에서 돌리는 거라
        visited[v] = true;
        for (int k : arr[v]) {
            if (visited[k] == false) {
                DFS(k);
            }
        }
    }
}