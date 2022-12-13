package Programmers.level0;

public class day4_피자나눠먹기_3 {
    public int solution(int slice, int n) {

        return n % slice == 0 ? n/slice : n/slice + 1;
    }

    public static void main(String[] args) {
        day4_피자나눠먹기_3 test = new day4_피자나눠먹기_3();
        System.out.println(test.solution(7,10));
    }
}
