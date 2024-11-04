import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[] m;
    static int[] c;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int total = 0;
        c = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            total += c[i];
        }
        dp = new int[N + 1][total + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i <= total; i++) {
            f(N, i);
        }
        for (int i = 0; i <= total; i++) {
            if (dp[N][i] >= M) {
                bw.write(String.valueOf(i));
                break;
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }

    static int f(int i, int j) {
        if (i < 1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (c[i] > j) {
            dp[i][j] = f(i - 1, j);
            return dp[i][j];
        }
        dp[i][j] = Math.max(f(i - 1, j), f(i - 1, j - c[i]) + m[i]);
        return dp[i][j];
    }
}
