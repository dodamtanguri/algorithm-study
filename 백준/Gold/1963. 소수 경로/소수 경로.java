import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        
        while (testCase-- > 0) {
            int start = scanner.nextInt();
            int target = scanner.nextInt();
            
            int[] visited = new int[10000];
            int[] dist = new int[10000];
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited[start] = 1;
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                
                if (current == target) {
                    System.out.println(dist[current]);
                    break;
                }
                
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 10; j++) {
                        int next = replaceDigit(current, i, j);
                        
                        if (next >= 1000 && visited[next] == 0 && isPrime(next)) {
                            queue.offer(next);
                            visited[next] = 1;
                            dist[next] = dist[current] + 1;
                        }
                    }
                }
            }
        }
        
        scanner.close();
    }
    
    public static int replaceDigit(int number, int position, int digit) {
        int[] digits = new int[4];
        
        for (int i = 0; i < 4; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        
        digits[position] = digit;
        
        int result = 0;
        
        for (int i = 3; i >= 0; i--) {
            result = result * 10 + digits[i];
        }
        
        return result;
    }
    
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
