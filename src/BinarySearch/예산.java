package BinarySearch;

import java.util.Arrays;

public class 예산 {
    static int left,right,sum,mid;
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int n = budgets.length;
        for(int i =0; i < n; i++) {
            sum += budgets[i];
        }
        Arrays.sort(budgets);
        if(sum <= M) {
            return budgets[n - 1];
        } else {
            left = 0;
            right = budgets[ n - 1];
            while (left <= right) {
                int current = 0;
                mid = (left + right) /2;
                for(int i = 0; i <n; i++) {
                    current += Math.min(budgets[i], mid);
                }
                if(current <= M) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return right;
        }
    }
}
