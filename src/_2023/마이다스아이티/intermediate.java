package _2023.마이다스아이티;

public class intermediate {
    private static int collect(int[][] mine, int r, int c, int n, int m) {

        // Base condition.
        if ((r < 0) || (r == n) || (c == m)) {
            return 0;
        }

        // Right upper diagonal.
        int upperDiagonal = collect(mine, r - 1, c + 1, n, m);

        // Straight right.
        int straight = collect(mine, r, c + 1, n, m);

        // Lower right diagonal.
        int lowerDiagonal = collect(mine, r + 1, c + 1, n, m);

        // Return the maximum gold collected.
        return mine[r][c] + Math.max(Math.max(upperDiagonal, straight), lowerDiagonal);
    }

    public static int maxGoldCollected(int[][] mine, int n, int m) {
        int maxGold = 0;

        for (int i = 0; i < n; i++) {

            // Recursive function call for  ith row.
            int goldCollected = collect(mine, i, 0, n, m);
            maxGold = Math.max(maxGold, goldCollected);
        }

        return maxGold;
    }


    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        long[][] a = {{1,4,5},{3,8,2},{10,0,6}};
        intermediate test = new intermediate();


    }

}
