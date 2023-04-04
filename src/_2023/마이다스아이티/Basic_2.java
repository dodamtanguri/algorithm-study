package _2023.마이다스아이티;

import java.util.Arrays;

public class Basic_2 {
    public String solution(String[][] score, int n, int m) {
        int numOfTeams = score.length;
        double[] avgScores = new double[numOfTeams];

        for(int i = 0; i < numOfTeams; i++) {
            double sum = 0;
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;

            for(int j = 0; j < score[i].length; j++) {
                double s = Double.parseDouble(score[i][j]);
                sum += s;
                max = Math.max(max, s);
                min = Math.min(min, s);
            }

            double avg = (sum - max - min) / (score[i].length - 2);
            avgScores[i] = avg;
        }

        Arrays.sort(avgScores);
        double[] reverseAvgScores = new double[numOfTeams];
        for(int i = 0; i < numOfTeams; i++) {
            reverseAvgScores[i] = avgScores[numOfTeams - i - 1];
        }
        avgScores = reverseAvgScores;

        int start = (m - 1) * n;
        int end = Math.min(start + n, avgScores.length);
        double sum = 0;

        for(int i = start; i < end; i++) {
            sum += avgScores[i];
        }
        double groupAvg = sum / n;

        return String.format("%.4f", groupAvg);
    }

    public static void main(String[] args) {
        String[][] score =  {{"0.00", "100.00", "20.00", "50.00"},
                {"0.00", "90.00", "20.00", "20.00"},
                {"10.00", "90.00", "30.00", "80.00"},
                {"0.00", "100.00", "40.00", "70.00"},
                {"0.00", "100.00", "10.00", "40.00"}};

        Basic_2 test = new Basic_2();
        System.out.println(test.solution(score, 2, 2));
    }
}
