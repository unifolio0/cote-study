import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int K;
    static int[] W;
    static int[] V;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        W = new int[N + 1];
        V = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(f(N, K)));

        bw.flush();

        bw.close();
        br.close();
    }

    static int f(int n, int k) {
        if (n < 1) {
            return 0;
        }
        if (dp[n][k] != -1) return dp[n][k];
        if (W[n] > k) {
            dp[n][k] = f(n - 1, k);
            return dp[n][k];
        }
        int re = Math.max(f(n - 1, k), f(n - 1, k - W[n]) + V[n]);
        dp[n][k] = re;
        return dp[n][k];
    }
}
