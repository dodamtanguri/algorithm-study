package Graph.BFS;

import java.util.*;

public class BOJ_13913 {
    static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 출발점
        int K = scanner.nextInt(); // 도착점

        int[] dist = new int[MAX + 1];
        int[] parent = new int[MAX + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                break;
            }

            int[] next = {current - 1, current + 1, current * 2};
            for (int i = 0; i < 3; i++) {
                if (next[i] >= 0 && next[i] <= MAX && dist[next[i]] == -1) {
                    queue.offer(next[i]);
                    dist[next[i]] = dist[current] + 1;
                    parent[next[i]] = current;
                }
            }
        }

        System.out.println(dist[K]);

        Stack<Integer> stack = new Stack<>();
        while (K != N) {
            stack.push(K);
            K = parent[K];
        }
        stack.push(N);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        scanner.close();
    }
}
