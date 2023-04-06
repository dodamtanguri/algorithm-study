import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int j = 0; j < commands.length; j++) {
            int[] temp = IntStream.range(commands[j][0]-1, commands[j][1])
                .map(i -> array[i]).toArray(); 
            Arrays.sort(temp);
            answer[j] = temp[commands[j][2]-1];
        }
        return answer;
    }
}