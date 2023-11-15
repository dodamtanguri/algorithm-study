import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 돌의 개수가 홀수이면 첫 번째 플레이어(Sangguen)가 이깁니다.
        if (N % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

        scanner.close();
    }
}
