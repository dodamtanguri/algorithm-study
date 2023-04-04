package Queue_Graph;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845 {

    //Queue Fist in First Out 인거 생각해서 구현하기
    // switch 문으로 깔끔하게 구현할 수 있음.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st;
        int lastNumber = 0;
        for (int i = 0; i < n; i++) {
            //출력해야하는 명령 한줄씩 가져와서
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                int temp = Integer.parseInt(st.nextToken());
                queue.add(temp);
                lastNumber = temp;
            }
            if (order.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    //queue의 첫번째 값을 반환하고 해당값 삭제
                    System.out.println(queue.poll());
                }
            }
            if (order.equals("size")) {
                System.out.println(queue.size());
            }
            if (order.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            if (order.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peek());
                }

            }
            if (order.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(lastNumber);
                }
            }


        }
    }
}
