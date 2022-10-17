package Programmers.level2;

public class 예상대진표 {
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while (true) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
            if(a == b) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        예상대진표 test = new 예상대진표();
        System.out.println(test.solution(8,4,7));
    }
}
