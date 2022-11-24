package CodingTest;
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_1874_스택으로오름차순수열만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList answer = new ArrayList();
        int n = Integer.parseInt(br.readLine()); //수열의 개수
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int num = 1;
        boolean result = true;
        Stack<Integer> stack = new Stack();
        for(int i = 1; i <= n; i++) {
            int current = arr[i];
            if(current >= num) {
                while (current>=num) {
                    stack.push(num++);
                    answer.add("+");
                }
                stack.pop();
                answer.add("-");
            }
            else { //현재 수열값 < 오름차순 자연수 : pop()을 수행했을 때 수열 원소를 꺼냄
                int temp = stack.pop();
                if(temp > current) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    answer.add("-");
                }
            }
        }
        if (result) {
           for(int i = 0; i < answer.size(); i++) {
               System.out.println(answer.get(i));
           }
        }
    }
}
