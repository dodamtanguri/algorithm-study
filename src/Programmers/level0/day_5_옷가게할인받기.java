package Programmers.level0;

public class day_5_옷가게할인받기 {
    public int solution(int price) {
        // 10만원 이상 > *0.95
        // 30만원 이상 > *0.9
        // 50만원 이상 > *0.8
        if(500000 <= price) {
            price *= 0.8;
        } else if (300000 <= price) {
            price *= 0.9;
        } else if(100000 <= price) {
            price *= 0.95;
        }
        return price;
    }
}
