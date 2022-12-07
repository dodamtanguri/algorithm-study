package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004_K번째수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1, k - 1);




    }

    private static void quickSort(int[] arr, int start, int end, int k) {

        if( start < end) {
            int pivot = patition(arr,start,end);
        }
    }

    private static int patition(int[] arr, int start, int end) {

        int m = (start + end) /2;
        swap(arr,start, m);
        int pivot = arr[start];
        int i = start , j = end;

        while (i < j) {
            while (pivot < arr[j]) {
                j--;
            }
        }
        return 0;
    }

    private static void swap(int[] arr, int start, int m) {
        int temp = arr[start];
        arr[start] = arr[m];
        arr[m] = temp;
    }
}
