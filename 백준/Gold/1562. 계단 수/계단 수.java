import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N][10][1 << 10];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int count = 0;
        for (int i = 1; i < 10; i++) {
            count = (count + f(N - 1, i, 1 << i)) % 1_000_000_000;
        }
        bw.write(String.valueOf(count % 1_000_000_000));

        bw.flush();

        bw.close();
        br.close();
    }

    private static int f(int dep, int i, int visit) {
        if (dep == 0) {
            if (visit == 1023) return 1;
            return 0;
        }
        if (dp[dep][i][visit] != -1) return dp[dep][i][visit];
        int count = 0;
        if (i > 0) {
            count = (count + f(dep - 1, i - 1, visit | 1 << (i - 1))) % 1_000_000_000;
        }
        if (i < 9) {
            count = (count + f(dep - 1, i + 1, visit | 1 << (i + 1))) % 1_000_000_000;
        }
        dp[dep][i][visit] = count % 1_000_000_000;
        return dp[dep][i][visit];
    }
}
