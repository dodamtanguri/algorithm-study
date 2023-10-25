import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(); // 테스트 케이스의 수
        
        for (int i = 0; i < T; i++) {
            int H = sc.nextInt(); // 호텔의 층 수
            int W = sc.nextInt(); // 각 층의 방 수
            int N = sc.nextInt(); // 손님의 번호
            
            int floor = N % H; // 손님의 층 수
            int room = (N / H) + 1; // 손님의 방 번호
            
            // 손님의 번호가 층 수로 나누어 떨어지는 경우
            if (floor == 0) {
                floor = H;
                room -= 1;
            }
            
            System.out.printf("%d%02d\n", floor, room);
        }
        
        sc.close();
    }
}
