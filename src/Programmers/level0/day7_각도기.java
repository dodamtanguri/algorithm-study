package Programmers.level0;

public class day7_각도기 {
    public int solution(int angle) {
        int ans = 0;
        if(angle == 90) {
            ans =  2;
        } else if(0 < angle && angle < 90) {
            ans =  1;
        } else if(90 < angle && angle < 180) {
            ans = 3;
        } else if (180 == angle) {
             ans =  4;
        }
        return ans;
    }
}
