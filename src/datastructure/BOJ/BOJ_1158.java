package datastructure.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1158 {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder("<");

        //1 ~ n 까지 deque에 삽입
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        while (!deque.isEmpty()) {
            //i = 0 일때 deque에 첫번째 수
            for (int i = 0; i < k - 1; i++) {
                deque.addLast(deque.removeFirst());
            }
            sb.append(deque.removeFirst()).append(", ");
        }
        System.out.println(sb.toString().substring(0, sb.length() - 2) + ">");
    }
}
