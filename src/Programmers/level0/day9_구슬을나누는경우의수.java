package Programmers.level0;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class day9_구슬을나누는경우의수 {
    public int solution(int balls, int share) {

        BigInteger under = BigInteger.valueOf(factorial(balls - share) * factorial(share));
        BigInteger top = BigInteger.valueOf(factorial(balls));
        return top.divide(under).intValue();
    }

    public long factorial(int n) {
        return LongStream.rangeClosed(1, n).reduce(1, (long num1, long num2) -> num1 * num2);
    }

    public static void main(String[] args) {
        day9_구슬을나누는경우의수 test = new day9_구슬을나누는경우의수();
        System.out.println(test.solution(30, 2));
    }
}
