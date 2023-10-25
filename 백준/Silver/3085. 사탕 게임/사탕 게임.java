import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] board = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            board[i] = sc.next().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(board, i, j, i, j + 1);
                    answer = Math.max(answer, getMax(board));
                    swap(board, i, j, i, j + 1);
                }

                if (i + 1 < N) {
                    swap(board, i, j, i + 1, j);
                    answer = Math.max(answer, getMax(board));
                    swap(board, i, j, i + 1, j);
                }
            }
        }
        System.out.println(answer);
    }

    public static int getMax(char[][] board) {
        int N = board.length;
        int result = 1;

        for (int i = 0; i < N; i++) {
            int temp = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    temp++;
                } else {
                    temp = 1;
                }
                result = Math.max(result, temp);
            }
        }

        for (int i = 0; i < N; i++) {
            int temp = 1;
            for (int j = 1; j < N; j++) {
                if (board[j][i] == board[j - 1][i]) {
                    temp++;
                } else {
                    temp = 1;
                }
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    public static void swap(char[][] board, int i, int j, int x, int y) {
        char temp = board[i][j];
        board[i][j] = board[x][y];
        board[x][y] = temp;
    }
}
