import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] d;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            d = new int[N + 1];
            Arrays.fill(d, Integer.MAX_VALUE);
            bw.write(f(N) + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (d[n] != Integer.MAX_VALUE) return d[n];
        return f(n - 3) + f(n - 2) + f(n - 1);
    }
}
