package Programmers.level0;

public class day7_양꼬치 {
    public int solution(int n, int k) {
        int answer = 0;
        answer  = (n * 12000) + (k * 2000);

        int temp = n / 10;

        answer  -= temp * 2000;

        return answer;
    }

    public static void main(String[] args) {
        day7_양꼬치 test = new day7_양꼬치();
        System.out.println(test.solution(10, 3));
    }
}
