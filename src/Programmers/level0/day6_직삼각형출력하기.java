package Programmers.level0;
import java.util.Scanner;

public class day6_직삼각형출력하기 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            for(int i = 1; i <= n; i++) {
                for(int j = 0; j < i; j++) {
                    System.out.print("*");
                }
            }
        }

}
