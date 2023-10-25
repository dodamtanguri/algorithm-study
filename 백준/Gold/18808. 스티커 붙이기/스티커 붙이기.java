import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[][] notebook;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        notebook = new int[N][M];

        for (int k = 0; k < K; k++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            int[][] sticker = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }

            for (int rot = 0; rot < 4; rot++) {
                if (attach(sticker)) break;
                sticker = rotate(sticker);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j] == 1) result++;
            }
        }
        System.out.println(result);
    }

    public static boolean attach(int[][] sticker) {
        int R = sticker.length;
        int C = sticker[0].length;

        for (int x = 0; x <= N - R; x++) {
            for (int y = 0; y <= M - C; y++) {
                boolean canAttach = true;
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (sticker[i][j] == 1 && notebook[x + i][y + j] == 1) {
                            canAttach = false;
                            break;
                        }
                    }
                    if (!canAttach) break;
                }

                if (canAttach) {
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            if (sticker[i][j] == 1) {
                                notebook[x + i][y + j] = 1;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static int[][] rotate(int[][] sticker) {
        int R = sticker.length;
        int C = sticker[0].length;
        int[][] rotated = new int[C][R];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                rotated[i][j] = sticker[R - 1 - j][i];
            }
        }
        return rotated;
    }
}
