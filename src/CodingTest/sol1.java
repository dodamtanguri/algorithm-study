package CodingTest;

public class sol1 {
    static int getSum (int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n /10;
        }
        return sum;
    }
    static int smallestNumber(int n) {
        int ans = 0;
        int i = n + 1;
        int temp = getSum(n);
        while (1 != 0) {
            if(getSum(i) == temp) {
                ans = i;
                break;
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(smallestNumber(1000));
        smallestNumber(1000);
    }
}
