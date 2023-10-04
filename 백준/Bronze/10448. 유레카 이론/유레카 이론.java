import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스 개수

        int[] triangular = new int[45];  // 삼각수를 저장할 배열
        for (int i = 1; i <= 44; i++) {
            triangular[i] = i * (i + 1) / 2;  // 삼각수를 계산하여 배열에 저장
        }

        while (T-- > 0) {
            int K = sc.nextInt();  // K를 입력받습니다.
            boolean found = false;  // K를 만들 수 있는지 판별하는 변수

            // 모든 삼각수의 경우를 확인합니다.
            for (int i = 1; i <= 44; i++) {
                for (int j = 1; j <= 44; j++) {
                    for (int k = 1; k <= 44; k++) {
                        if (triangular[i] + triangular[j] + triangular[k] == K) {
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
                if (found) break;
            }

            if (found) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
