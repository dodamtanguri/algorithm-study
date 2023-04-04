package Programmers;

import Queue_Graph.BOJ_10845;

import java.util.Arrays;
import java.util.stream.IntStream;

public class K번째수 {
    //i 부터 j 까지 자른 새로운 배열 : temp[]
    // temp sorting
    // 정렬된 배열 temp 에서 k번째 수 찾기
    public int[] solution(int[] array, int[][] commands) {
        //commands [열][행]
        int testCase = commands.length;
        int[] answer = new int[testCase]; // test case 의 갯수
        for(int i = 0; i < testCase; i++) {
            int[] temp = IntStream.range(commands[i][0]-1,commands[i][1]).map(j ->array[j] ).toArray();
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        K번째수 test = new K번째수();
        System.out.println(Arrays.toString(test.solution(array, commands)));
    }
}
