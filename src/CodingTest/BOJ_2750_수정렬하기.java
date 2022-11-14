package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2750_수정렬하기 {
    //N개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성
    //제한시간 2초
    //연산 횟수는 1초에 1억 번 연산하는 것을 기준으로 생각하기
    //시간 복잡도는 항상 최악일때, 즉 데이터의 크기가 가장 클 떄를 기준으로 함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
        //시간복잡도는 가장 많이 중첩된 반복문응ㄹ 기준으로 도출
        //이중 for문이 전체코드의 시간복잡도 기준이 됨
        //o(n) 제곱 이되는거지 이거 이중 포문이잖아
        //선택정렬로 풀었을 경우
//        for(int i = 0; i < arr.length-1; i++) {
//           for(int j = i + 1; j < arr.length; j++) {
//               if(arr[i] > arr[j]) {
//                   int temp = arr[j];
//                   arr[j] = arr[i];
//                   arr[i] = temp;
//               }
//           }
//        }

        //카운팅 정렬일 경우
        boolean[] arr2 = new boolean[2001];
        for(int i = 0; i < n; i++) {
            int temp2 = Integer.parseInt(br.readLine());
            arr2[temp2 + 1000] = true;
        }

        for(int i = 0; i<2001; i++) {
            if(arr2[i]) {
                System.out.println(i - 1000);
            }
        }

//        for(int i = 0; i < n; i++) {
//            System.out.println(arr[i]);
//        }

        for(int i = 0; i < n; i++) {
            System.out.println(arr2[i]);
        }

    }


}
