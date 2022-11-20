package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018_투포인터 {
    public static void main(String[] args) throws IOException {
        //몇 개의 연속된 자연수의 합으로 나타내는 가짓수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //O(nlogn)의 시간복잡도 알고리즘 사용시 제한시간 초과 >> O(n)의 시간 복잡도 알고리즘 사용
        //연속된 자연수의 합을 구하는것이 문제
        //시작인덱스와 종료인덱스를 지정하여 연속된 수 표현

        int cnt = 1; // N == 15이므로 15에 startIndex랑 EndIndex가 모두 있을때 경우의 수 하나 더해줌
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while (endIndex != n) {
            if (sum == n) {
                cnt++;
                endIndex++;
                sum = sum + endIndex;
            } else if (sum > n) {
                sum = sum - startIndex;
                startIndex++;
            } else if (sum < n) {
                endIndex++;
                sum = sum + endIndex;
            }
        }
        System.out.println(cnt);
    }
}
