import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static int[] d;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        long[] d = new long[1_000_001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i < 1_000_001; i++) {
            d[i] = ((d[i - 3] % 1_000_000_009) + (d[i - 2] % 1_000_000_009) + (d[i - 1] % 1_000_000_009)) % 1_000_000_009;
        }
        for (int t = 0; t < T; t++) {
            /*int N = Integer.parseInt(br.readLine());
            d = new int[N + 1];
            Arrays.fill(d, Integer.MAX_VALUE);
            bw.write((f(N) % 1_000_000_009) + "\n");*/
            int n = Integer.parseInt(br.readLine());
            bw.write(d[n] + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }/*

    private static int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (d[n] != Integer.MAX_VALUE) return d[n];
        return ((f(n - 3) % 1_000_000_009) + (f(n - 2) % 1_000_000_009) + (f(n - 1) % 1_000_000_009)) % 1_000_000_009;
    }*/
}
