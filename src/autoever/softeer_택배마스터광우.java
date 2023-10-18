package autoever;

import java.util.Scanner;

public class softeer_택배마스터광우 {
    static int N, M, K, ans = Integer.MAX_VALUE;
    static int[] rails, perm;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        rails = new int[N];
        perm = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            rails[i] = sc.nextInt();
        }

        permutation(0);
        System.out.println(ans);
        sc.close();
    }

    static void permutation(int depth) {
        if(depth == N) {
            int sum = 0;
            for(int i=0; i<K; i++) {
                int weight = 0;
                int idx = 0;
                while(idx < N && weight + perm[idx] <= M) {
                    weight += perm[idx++];
                }
                sum += weight;
            }
            ans = Math.min(ans, sum);
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                perm[depth] = rails[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
