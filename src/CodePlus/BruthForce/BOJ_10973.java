package CodePlus.BruthForce;

public class BOJ_10973 {
    static boolean prev_permutation(int[] nums) {
        int i = nums.length - 1;
        //1. 첫번째 순열 구하기
        int j = nums.length - 1;
        while (nums[j] >= nums[i-1]) {
            j -= 1;
        }
        while (i > 0 && nums[i-1] <= nums[i]) {
            i -= 1;
        }
        if( i <= 0) {
            return false;
        }
        int temp = nums[i-1];
        nums[i-1] = nums[i];
        nums[j] = temp;


         return true;
    }
}
