import java.util.*;

public class Main {

    static int[][] board;

    static int X1, Y1, X2, Y2;

    public static boolean isBlocked(int x, int y, int dir) {

        if (dir == 0) { // 아래로 이동

            return X1 == X2 && X1 == x && Y1 <= y && y < Y2;

        }

        if (dir == 1) { // 오른쪽으로 이동

            return Y1 == Y2 && Y1 == y && X1 <= x && x < X2;

        }

        return false;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();

        board = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                board[i][j] = sc.nextInt();

            }

        }

        X1 = sc.nextInt();

        Y1 = sc.nextInt();

        X2 = sc.nextInt();

        Y2 = sc.nextInt();

        if (X1 > X2) { int temp = X1; X1 = X2; X2 = temp; }

        if (Y1 > Y2) { int temp = Y1; Y1 = Y2; Y2 = temp; }

        int[][] dp = new int[n][m];

        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);

        dp[0][0] = board[0][0];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (dp[i][j] == Integer.MIN_VALUE) continue;

                if (i + 1 < n && !isBlocked(i + 1, j, 0)) {

                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + board[i + 1][j]);

                }

                if (j + 1 < m && !isBlocked(i, j + 1, 1)) {

                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + board[i][j + 1]);

                }

            }

        }

        if (dp[n - 1][m - 1] == Integer.MIN_VALUE) {

            System.out.println("Entity");

        } else {

            System.out.println(dp[n - 1][m - 1]);

        }

    }

}