import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int A;
    static int B;
    static int[] button;
    static int[][][] dp;
    static int MAX = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        button = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            button[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][13][13];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 13; j++) {
                for (int k = 0; k < 13; k++) {
                    dp[i][j][k] = MAX;
                }
            }
        }
//        for (int i = 1; i < 13; i++) {
//            for (int j = 1; j < 13; j++) {
//                System.out.printf("i: %d, j: %d, move(%d, %d): %d%n", i, j, i, j, move(i, j));
//            }
//        }
        dp[0][button[0]][3] = move(1, button[0]) + A;
        dp[0][1][button[0]] = move(3, button[0]) + B;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= 12; j++) {
                for (int k = 1; k <= 12; k++) {
                    if (dp[i - 1][j][k] == MAX) continue;
                    dp[i][button[i]][k] = Math.min(dp[i - 1][j][k] + move(j, button[i]) + A, dp[i][button[i]][k]);
//                    System.out.println("move(j, button[i]): " + move(j, button[i]));
                    dp[i][j][button[i]] = Math.min(dp[i - 1][j][k] + move(k, button[i]) + B, dp[i][j][button[i]]);
//                    System.out.println("move(k, button[i]): " + move(k, button[i]));
//                    System.out.printf("i: %d, j: %d, k: %d, button[%d]: %d, dp[%d][%d][%d] = %d, dp[%d][%d][%d]: %d, dp[%d][%d][%d]: %d%n", i, j, k, i, button[i], i - 1, j, k, dp[i - 1][j][k], i, button[i], k, dp[i][button[i]][k], i, j, button[i], dp[i][j][button[i]]);
                }
            }
        }
        int max = MAX;
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12; j++) {
                if (dp[N - 1][i][j] == MAX) continue;
                max = Math.min(max, dp[N - 1][i][j]);
            }
        }
        bw.write(String.valueOf(max));

        bw.flush();

        bw.close();
        br.close();
    }

    static int move(int cur, int next) {
        int x1 = ((cur / 3) - (cur % 3 == 0 ? 1 : 0));
        int x2 = ((next / 3) - (next % 3 == 0 ? 1 : 0));
        int y1 = cur % 3 == 0 ? 3 : cur % 3;
        int y2 = next % 3 == 0 ? 3 : next % 3;
//        System.out.printf("x1: %d, x2: %d, y1: %d, y2: %d%n", x1, x2, y1, y2);
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
