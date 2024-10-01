import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int div = 1_000_000_007;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[M][26];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = div;
            }
        }
        int s = 0;
        for (int i = 0; i < 26; i++) {
            s += f(i, 0) % div;
            s %= div;
        }
        bw.write(String.valueOf(s));

        br.close();

        bw.flush();
        bw.close();
    }
    
    static public int f(int cur, int dep) {
        if (dep == M - 1) {
            dp[dep][cur] = 1;
            return 1;
        }
        if (dp[dep][cur] != div) return dp[dep][cur];
        int k = 0;
        for (int i = 0; i < 26; i++) {
            if (Math.abs(i - cur) >= N) {
                k += f(i, dep + 1) % div;
                k %= div;
            }
        }
        dp[dep][cur] = k % div;
        return k % div;
    }
}
