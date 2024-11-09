import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            map = new int[N][M];
            dp = new int[N][M];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], -1);
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 0) {
                        dp[i][j] = 0;
                    }
                }
            }
            int re = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    re = Math.max(f(i, j), re);
                }
            }

            bw.write(re + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }

    private static int f(int x, int y) {
        if (x >= N || y >= M) return 0;
        if (dp[x][y] != -1) return dp[x][y];
        int re = Math.min(f(x + 1, y), Math.min(f(x, y + 1), f(x + 1, y + 1))) + 1;
        dp[x][y] = re;
        return re;
    }
}
