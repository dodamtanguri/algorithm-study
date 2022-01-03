package datastructure;

import java.util.Arrays;

public class MergeSort_1 {
    static int[] left, right, sorted;
    static int leftPoint = 0;
    static int rightPoint = 0;
    static int idx = 0;

    public int[] splitFunc(int[] dataList) {
        if (dataList.length <= 1) {
            return dataList;
        }
        int mid = dataList.length / 2;
        left = new int[mid];
        left = splitFunc(Arrays.copyOfRange(dataList, 0, mid));

        right = new int[mid];
        right = splitFunc(Arrays.copyOfRange(dataList, mid, dataList.length));

        return this.mergeFunc(left, right);
    }

    private int[] mergeFunc(int[] left, int[] right) {
        sorted = new int[left.length + right.length];
        while (left.length > leftPoint && right.length > rightPoint) {
            if (left[leftPoint] > right[rightPoint]) {
                sorted[idx] = right[rightPoint];
                idx++;
                rightPoint++;
            } else {
                sorted[idx] = left[leftPoint];
                idx++;
                leftPoint++;
            }
        }
        while (left.length >= leftPoint) {
            sorted[idx] = left[leftPoint];
            idx++;
            leftPoint++;
        }

        while (right.length >= rightPoint) {
            sorted[idx] = left[rightPoint];
            idx++;
            rightPoint++;
        }
        return sorted;
    }

    public static void main(String[] args) {
        MergeSort_1 test = new MergeSort_1();
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println(Arrays.toString(test.splitFunc(arr)));
    }
}
