import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] numbers;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[st.countTokens() - 1];
        dp = new int[numbers.length][5][5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], 1_000_000_000);
            }
        }
        dp[0][numbers[0]][0] = 2;
        dp[0][0][numbers[0]] = 2;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    int n = numbers[i + 1];
                    if (dp[i][j][k] == 0) continue;
                    dp[i + 1][n][k] = Math.min(dp[i + 1][n][k], dp[i][j][k] + move(j, n));
                    dp[i + 1][j][n] = Math.min(dp[i + 1][j][n], dp[i][j][k] + move(k, n));
                }
            }
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (dp[numbers.length - 1][i][j] == 1_000_000_000) continue;
                max = Math.min(max, dp[numbers.length - 1][i][j]);
            }
        }
        bw.write(String.valueOf(max));

        bw.flush();

        bw.close();
        br.close();
    }

    static int move(int cur, int next) {
        if (cur == next) return 1;
        if (cur == 0) return 2;
        if (Math.abs(cur - next) == 2) return 4;
        return 3;
    }
}
