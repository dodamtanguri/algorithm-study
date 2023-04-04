package _2023.마이다스아이티;


import java.util.Arrays;
import java.util.Comparator;

public class Basic {
    public String solution(String[][] score, int n, int m) {
        int row = score.length;
        double[] temp = new double[row];
        for (int i = 0; i < row; i++) {
            double sum = 0;
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;
            for (int j = 0; j < score[i].length; j++) {
                double s = Double.parseDouble(score[i][j]);
                sum += s;
                max = Math.max(max, s);
                min = Math.min(min, s);
            }
            // exclude highest and lowest scores
            double avg = (sum - max - min) / (score[i].length - 2)   ;
            temp[i] = avg;
        }

        //평균점수가 높은 순서대로 조편성 (오름차순으로 정렬)
        Arrays.sort(temp);
        double[] reverseTemp = new double[row];
        for (int i = 0; i < row; i++) {
            reverseTemp[i] = temp[row - i - 1];
        }
        temp = reverseTemp;

        // calculate the average score of the mth group of n players
        int start = (m - 1) * n;
        int end = Math.min(start + n, temp.length);
        double sum = 0;
        int count = 0;
        for (int i = start; i < end; i++) {
            sum += temp[i];
            count++;
        }
        double groupAvg = sum / count;

        return String.format("%.4f", groupAvg);
    }

    public static void main(String[] args) {
        String[][] score =  {{"0.00", "100.00", "20.00", "50.00"},
                {"0.00", "90.00", "20.00", "20.00"},
                {"10.00", "90.00", "30.00", "80.00"},
                {"0.00", "100.00", "40.00", "70.00"},
                {"0.00", "100.00", "10.00", "40.00"}};

        Basic test = new Basic();
        System.out.println(test.solution(score,2,2));
    }
}
