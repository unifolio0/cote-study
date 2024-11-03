import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp;
    static List<Matrix> matrixs;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        matrixs = new ArrayList<>();
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrixs.add(new Matrix(r, c));
        }

        bw.write(String.valueOf(f(0, N - 1)));

        bw.flush();

        bw.close();
        br.close();
    }

    private static int f(int start, int end) {
        if (end - start == 0) return 0;
        if (end - start == 1) {
            dp[start][end] = matrixs.get(start).r * matrixs.get(start).c * matrixs.get(end).c;
            return dp[start][end];
        }
        if (dp[start][end] != 0) return dp[start][end];
        int re = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            re = Math.min(re, f(start, i) + f(i + 1, end) + matrixs.get(start).r * matrixs.get(i).c * matrixs.get(end).c);
        }
        dp[start][end] = re;
        return dp[start][end];
    }

    static class Matrix {
        int r;
        int c;

        Matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
