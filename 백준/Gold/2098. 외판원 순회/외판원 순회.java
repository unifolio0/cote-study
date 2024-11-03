import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] W;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][(1 << N) - 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(String.valueOf(f(0, 1)));

        bw.flush();

        bw.close();
        br.close();
    }

    static int f(int cur, int visit) {
        if (visit == (1 << N) - 1) {
            if (W[cur][0] == 0) return 100_000_000;
            return W[cur][0];
        }
        if (dp[cur][visit] != 0) return dp[cur][visit];
        int re = 100_000_000;
        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) == 0 && W[cur][i] != 0) {
                re = Math.min(re, f(i, visit | (1 << i)) + W[cur][i]);
            }
        }
        dp[cur][visit] = re;
        return dp[cur][visit];
    }
}
