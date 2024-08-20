import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br =   new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] d;
    static int[] steps;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        steps = new int[N];
        for (int i = 0; i < N; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }
        d = new int[N][2];
        bw.write(String.valueOf(Math.max(f(0, 0), f(1, 0))));

        br.close();

        bw.flush();
        bw.close();
    }

    private static int f(int step, int count) {
        if (step >= N) return -100_000_000;
        if (step == N - 1) return steps[step];
        if (d[step][count] != 0) return d[step][count];
        if (count == 0) d[step][count] = Math.max(f(step + 1, 1), f(step + 2, 0)) + steps[step];
        else d[step][count] = f(step + 2, 0) + steps[step];
        return d[step][count];
    }
}
