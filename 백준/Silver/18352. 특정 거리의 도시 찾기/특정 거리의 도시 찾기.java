import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     * n = 도시 (정점)
     * m = 단방향 도로의 개수(간선의 개수)
     * x = 출발 도시 (시작점 번호)
     * k = 최단거리
     * 최단거리가 k인 도시의 번호 출력
     * 만약 하나도 존재하지 않으면 -1 출력
     */
    static final int max_int = 300001;
    static int n, m, k, x, a, b, result;
    static int[] check = new int[max_int];

    static ArrayList<Integer> arr[] = new ArrayList[max_int];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            check[i] = -1;
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a].add(b); //단방향
        }

        bfs();
        boolean target = false;
        for (int i = 1; i <= n; i++) {
            if (k == check[i]) {
                System.out.println(i);
                target = true;
            }
        }
        if (!target) {
            System.out.println(-1);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        check[x] = 0;
        queue.add(x);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < arr[node].size(); i++) {
                int next = arr[node].get(i);
                if (check[next] == -1) {
                    check[next] = check[node] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
