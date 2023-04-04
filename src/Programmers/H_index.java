package Programmers;

import java.util.Arrays;

public class H_index {
    //citations[0] >= h 의 최댓값
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
