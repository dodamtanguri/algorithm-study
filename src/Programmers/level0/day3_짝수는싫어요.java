package Programmers.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class day3_짝수는싫어요 {
    public int[] solution(int n) {


       IntStream range = IntStream.rangeClosed(1, n);

       return range.filter(i -> i % 2 != 0).toArray();



    }

    public static void main(String[] args) {
        IntStream range = IntStream.rangeClosed(1, 10);

        System.out.println(Arrays.toString(range.filter(i -> i % 2 != 0).toArray()));

    }
}
