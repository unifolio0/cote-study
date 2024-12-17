import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N][10][1 << 10];
        for (int i = 1; i < 10; i++) {
            dp[0][i][1 << i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1 << 10; k++) {
                    if (j - 1 >= 0) {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];
                    }
                    if (j + 1 < 10) {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];
                    }
                    dp[i][j][k | (1 << j)] %= 1_000_000_000;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count += dp[N - 1][i][1023];
            count %= 1_000_000_000;
        }
        bw.write(String.valueOf(count));

        bw.flush();

        bw.close();
        br.close();
    }
}
