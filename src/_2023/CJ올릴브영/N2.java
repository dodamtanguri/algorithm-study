package _2023.CJ올릴브영;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class N2 {
    public static class State {
        String current;
        int keyPress;

        public State(String current, int keyPress) {
            this.current = current;
            this.keyPress = keyPress;
        }
    }

    public static int minKeyPress(String number) {
        // 예외처리
        if (number == null || number.length() == 0) {
            return 0;
        }

        // 초기값 설정
        int result = Integer.MAX_VALUE;
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new State("", 0));

        // BFS 탐색
        while (!queue.isEmpty()) {
            State currState = queue.poll();

            // 현재 상태가 입력하려는 수와 같으면 최소값 업데이트
            if (currState.current.equals(number)) {
                result = Math.min(result, currState.keyPress);
                continue;
            }

            // 일반 입력 (고장난 키보다 숫자를 먼저 입력하는 경우)
            for (int i = 0; i < number.length(); i++) {
                int nextDigit = Character.getNumericValue(number.charAt(i));
                String next = currState.current + nextDigit;
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(new State(next, currState.keyPress + 1));
                }
            }

            // 백스페이스 (이미 입력된 숫자를 삭제하는 경우)
            if (!currState.current.isEmpty()) {
                String next = currState.current.substring(0, currState.current.length() - 1);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(new State(next, currState.keyPress + 1));
                }
            }

            // 고장난 키 입력 (우측 숫자도 함께 입력되는 경우)
            for (int i = 0; i < number.length() - 1; i++) {
                int currentDigit = Character.getNumericValue(number.charAt(i));
                int nextDigit = Character.getNumericValue(number.charAt(i + 1));
                if (currentDigit == nextDigit) {
                    String next = currState.current + currentDigit + nextDigit;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(new State(next, currState.keyPress + 1));
                    }
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result; // 예외처리 : 결과값이 최대값인 경우 -1 반환
    }

    public static void main(String[] args) {
        String[] numbers = {"12156", "321", "1234567", "100", ""};
        int[] expected = {4, 6, 5, 4, 0};
        for (int i = 0; i < numbers.length; i++) {
            String number = numbers[i];
            int result = minKeyPress(number);
            System.out.println("number : " + number + " result : " + result + " (Expected: " + expected[i] + ")");
        }
    }
}