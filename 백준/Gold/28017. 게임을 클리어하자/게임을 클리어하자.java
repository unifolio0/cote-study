import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[][] weapons;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        int mmmm = 100_000_000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weapons = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                weapons[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][M];
        for (int i = 0; i<N;i++){
            for (int j = 0; j<M;j++){
                dp[i][j]=mmmm;
            }
        }
        for (int i = 0;i<M;i++){
            dp[0][i] = weapons[0][i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int l = 0; l < M; l++) {
                    if (j == l) continue;
                    dp[i][j] = Math.min(dp[i][j], weapons[i][j] + dp[i - 1][l]);
                }
            }
        }
        int k = dp[N-1][0];
        for (int i = 0; i < M; i++) {
            k = Math.min(k, dp[N - 1][i]);
        }
        bw.write(String.valueOf(k));

        br.close();

        bw.flush();
        bw.close();
    }
}

