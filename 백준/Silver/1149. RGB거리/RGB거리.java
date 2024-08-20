import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br =   new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] d;
    static int[][] steps;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        steps = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            steps[i][0] = Integer.parseInt(st.nextToken());
            steps[i][1] = Integer.parseInt(st.nextToken());
            steps[i][2] = Integer.parseInt(st.nextToken());
        }
        d = new int[N][3];
        bw.write(String.valueOf(Math.min(Math.min(f(0, 0), f(0, 1)), f(0, 2))));

        br.close();

        bw.flush();
        bw.close();
    }

    private static int f(int n, int c) {
        if (n == N) return 0;
        if (d[n][c] != 0) return d[n][c];
        if (c == 0) {
            d[n][c] = Math.min(f(n + 1, 1), f(n + 1, 2)) + steps[n][c];
        }
        if (c == 1) {
            d[n][c] = Math.min(f(n + 1, 0), f(n + 1, 2)) + steps[n][c];
        }
        if (c == 2) {
            d[n][c] = Math.min(f(n + 1, 1), f(n + 1, 0)) + steps[n][c];
        }
        return d[n][c];
    }
}
