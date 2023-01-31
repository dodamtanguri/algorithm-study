package CodePlus.BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10972 {
    static int[] nums;

    static boolean next_permutation(int[] nums) {
        int i = nums.length - 1;
        //1. 마지막 순열 구하기
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false; // 마지막 순열
        }
        int j = nums.length - 1;
        while (nums[j] <= nums[i - 1]) {
            j -= 1;
        }

        int temp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = temp;

        j = nums.length - 1;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (next_permutation(nums)) {
            for (int i = 0; i < n; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }

    }
}
