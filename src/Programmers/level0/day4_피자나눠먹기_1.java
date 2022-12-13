package Programmers.level0;

public class day4_피자나눠먹기_1 {
    public int solution(int n) {
        if(n == 1) {
           return 1;
        }
        if(n % 7 == 0) {
            return n / 7;
        }
        return (n / 7) + 1;
    }
}
