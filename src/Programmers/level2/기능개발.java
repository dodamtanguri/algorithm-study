package Programmers.level2;




import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        //1.프로세스에 있는 현재 진행률 에 스피드를 몇번 더했을 때 진도율이 100이 넘는지
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < speeds.length; i++) {
            //남은 일수 계산해서 queue에 추가
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);
            //
            if(!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }
            q.offer(date);
        }
        answerList.add(q.size());
        return answer;
    }
}
