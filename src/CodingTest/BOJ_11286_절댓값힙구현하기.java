package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙구현하기 {
    public static void main(String[] args) throws IOException {
        //우선순위 큐로 정렬 기준 정의
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //질의 요청 갯수

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //비교 대상 값들 절대값으로 변환
                int firstTarget = Math.abs(o1);
                int secondTarget = Math.abs(o2);
                //가장작은 절대값들이 여러개일 경우, 그중 가장 작은 수를 출력
                if (firstTarget == secondTarget)
                    return o1 > o2 ? 1 : -1;
                else
                    //절대값이 가장 작은 수 출력
                    return firstTarget - secondTarget;

            }
        });

        for(int i = 0; i < n; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(queue.isEmpty()) {
                    System.out.println("0");
                } else{
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(request);
            }
        }
    }
}
