package CodingTest;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003_최솟값찾기 {


    public static void main(String[] args) throws IOException {
        //슬라이딩 윈도우와 정렬 >> deque
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //숫자의 크기
        int m = Integer.parseInt(st.nextToken()); //슬라이딩 윈도우의 크기

        st = new StringTokenizer(br.readLine());

        //ArrayDeque로 변경하니까 해결됨
        ArrayDeque<Node> mydeque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());
            //최소값 가능성이 없는 data 삭제
            while (!mydeque.isEmpty() && mydeque.getLast().value > current) {
                //last in deque > index 2 , value : 5 vs current > index : 3, value : 2
                mydeque.removeLast();
            }
            //현재 node 추가
            mydeque.addLast(new Node(current, i));
            //윈도우의 범위를 벗어나는 데이터 삭제
            if (mydeque.getFirst().index <= i - m) {
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int value;
        public int index;


    }
}
