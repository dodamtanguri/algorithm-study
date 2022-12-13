package Programmers.level0;

public class day4_피자나눠먹기_2 {

    public static int gdc(int n) {
        int a = 6; // 어짜피 피자는 6조각이니까
        if(a < n) {
            a = n;
            n = 6;
        }
        while (n != 0) {
            int r = a % n;
            a = n;
            n = r;
        }
        return a;
    }
    static int lcm(int n) {
        return 6 * n / gdc(n);
    }
    //최소공배수
    public int solution(int n) {
       return lcm(n) / 6;
    }

    public static void main(String[] args) {
        day4_피자나눠먹기_2 test = new day4_피자나눠먹기_2();
        System.out.println(test.lcm(10));
    }
}
