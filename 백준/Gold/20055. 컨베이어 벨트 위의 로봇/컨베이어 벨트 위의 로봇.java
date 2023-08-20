import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * N];
        boolean[] robots = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        
        int step = 0; 
        while(true) {
            
            step++; 
            
            int lastBelt = belt[2 * N - 1];
            for(int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i-1];
                if(i < N ) {
                    robots[i] = robots[i-1];
                }
            }
            // 첫번째 값을 마지막칸의 값으로 업데이트 
        belt[0] = lastBelt;         
        
        robots[0] = false; 
        robots[N - 1] = false; //N번 칸이 있는 위치를 "내리는 위치" >> 로봇을 제거 
       
        for(int i = N - 2; i >= 0; i--) {
            if( robots[i] && !robots[i + 1] && belt[i + 1] > 0) {
                robots[i+1] = true;
                robots[i] = false;
                belt[i+1]--;
            
            if(i + 1 == N - 1) {
                robots[N-1] = false;
            }
          }
        }
        //새로운 로봇을 벨트위에 올려놓는 작업    
        if(!robots[0] && belt[0] > 0) {
            robots[0] = true;
            belt[0]--;
        }
        // 벨트의 내구성 체크     
        int count = 0; 
        for(int i = 0; i < 2 * N; i++) {
            if(belt[i] == 0 ) count++;
        }
        if(count >= K ) break; 
        } 
      
        System.out.println(step);
    }
}
