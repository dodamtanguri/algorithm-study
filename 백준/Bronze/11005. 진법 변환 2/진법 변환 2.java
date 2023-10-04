import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  // 10진법 수
        int B = sc.nextInt();  // 변환하려는 진법
        StringBuilder answer = new StringBuilder();  // 진법 변환 결과를 저장할 StringBuilder
        
        while (N > 0) {
            int remainder = N % B;  // 나머지
            if (remainder < 10) {
                answer.insert(0, remainder);  // 나머지가 10보다 작으면 그대로 추가
            } else {
                answer.insert(0, (char) (remainder - 10 + 'A'));  // 나머지가 10 이상이면 알파벳으로 변환하여 추가
            }
            N /= B;  // N을 B로 나눈 몫을 새로운 N으로 정의
        }
        
        System.out.println(answer);  // 결과 출력
    }
}
