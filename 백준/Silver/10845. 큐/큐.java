import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(queue, num);
                    break;
                case "pop":
                    pop(queue, output);
                    break;
                case "size":
                    size(queue, output);
                    break;
                case "empty":
                    empty(queue, output);
                    break;
                case "front":
                    front(queue, output);
                    break;
                case "back":
                    back(queue, output);
                    break;
            }
        }

        System.out.println(output.toString());
    }

    private static void push(Queue<Integer> queue, int num) {
        queue.add(num);
    }

    private static void pop(Queue<Integer> queue, StringBuilder output) {
        if (queue.isEmpty()) {
            output.append("-1\n");
        } else {
            output.append(queue.poll()).append("\n");
        }
    }

    private static void size(Queue<Integer> queue, StringBuilder output) {
        output.append(queue.size()).append("\n");
    }

    private static void empty(Queue<Integer> queue, StringBuilder output) {
        output.append(queue.isEmpty() ? "1\n" : "0\n");
    }

    private static void front(Queue<Integer> queue, StringBuilder output) {
        if (queue.isEmpty()) {
            output.append("-1\n");
        } else {
            output.append(queue.peek()).append("\n");
        }
    }

    private static void back(Queue<Integer> queue, StringBuilder output) {
        if (queue.isEmpty()) {
            output.append("-1\n");
        } else {
            output.append(((LinkedList<Integer>) queue).getLast()).append("\n");
        }
    }
}
