import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] rgbs;
    static int[][][] dp;

    public static void main (String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        rgbs = new int[N][3];
        dp = new int[N][3][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 100_000_000;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgbs[i][0] = Integer.parseInt(st.nextToken());
            rgbs[i][1] = Integer.parseInt(st.nextToken());
            rgbs[i][2] = Integer.parseInt(st.nextToken());
        }
        int r = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            r = Integer.min(r, f(1, i, i) + rgbs[0][i]);
        }

        bw.write(String.valueOf(r));

        bw.flush();

        bw.close();
        br.close();
    }

    public static int f (int dep, int before, int first) {
        if (dep == N - 1) {
            int k = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != before && i != first) {
                    k = Math.min(k, rgbs[N - 1][i]);
                }
            }
            return k;
        }
        if (dp[dep][before][first] != 100_000_000) {
            return dp[dep][before][first];
        }
        int k = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != before) {
                k = Math.min(k, f(dep + 1, i, first) + rgbs[dep][i]);
            }
        }
        dp[dep][before][first] = k;
        return k;
    }
}
