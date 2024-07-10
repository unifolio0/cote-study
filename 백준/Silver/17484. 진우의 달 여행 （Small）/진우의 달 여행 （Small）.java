import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] space = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0 : 우하
        // 1 : 하
        // 2 : 좌하
        int[][][] dp = new int[N][M][3];
        for (int i = 0; i < M; i++) {
            dp[0][i][0] = space[0][i];
            dp[0][i][1] = space[0][i];
            dp[0][i][2] = space[0][i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][0] = Integer.MAX_VALUE;
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + space[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + space[i][j];
                } else if (j > 0 && j < M - 1) {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + space[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + space[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + space[i][j];
                } else if (j == M - 1) {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + space[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + space[i][j];
                    dp[i][j][2] = Integer.MAX_VALUE;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[N - 1][i][j]);
            }
        }

        bw.write(String.valueOf(min));

        br.close();

        bw.flush();
        bw.close();
    }
}
