package datastructure;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Integer> splitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int mid = dataList.size() / 2;
        ArrayList<Integer> left;
        ArrayList<Integer> right;

        left = this.splitFunc(new ArrayList<Integer>(dataList.subList(0, mid)));
        right = this.splitFunc(new ArrayList<Integer>(dataList.subList(mid, dataList.size())));

        return this.mergeFunc(left, right);

    }

    private ArrayList<Integer> mergeFunc(ArrayList<Integer> left, ArrayList<Integer> right) {
        int leftPoint = 0, rightPoint = 0;
        ArrayList<Integer> mergeList = new ArrayList<>();
        //left 와 right 모두 남아있을 경우
        while (left.size() > leftPoint && right.size() > rightPoint) {
            if (left.get(leftPoint) > right.get(rightPoint)) {
                mergeList.add(right.get(rightPoint));
                rightPoint++;
            } else {
                mergeList.add(left.get(leftPoint));
                leftPoint++;
            }
        }

        while (left.size() > leftPoint) {
            mergeList.add(left.get(leftPoint));
            leftPoint++;
        }
        while (right.size() > rightPoint) {
            mergeList.add(right.get(rightPoint));
            rightPoint++;
        }

        return mergeList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int) (Math.random() * 100));
        }

        MergeSort mSort = new MergeSort();
        System.out.println(mSort.splitFunc(testData));
    }

}
