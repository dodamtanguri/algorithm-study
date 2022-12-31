package Programmers.level0;

public class day10_공던지기 {
    public int solution(int[] numbers, int k) {
        return 2 * (k - 1) % numbers.length + 1   ;
    }

    public static void main(String[] args) {
        day10_공던지기 test = new day10_공던지기();
        System.out.println(test.solution(new int[] {1,2,3,4},2));
        System.out.println(test.solution(new int[] {1,2,3,4,5,6},5));
        System.out.println(test.solution(new int[] {1,2,3},3));
    }
}
