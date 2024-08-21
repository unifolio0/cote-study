import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static long[] d;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        d = new long[T + 1];
        bw.write(f(T) + "\n");

        br.close();

        bw.flush();
        bw.close();
    }

    private static long f(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (d[n] != 0) return d[n];
        d[n] = ((f(n - 1) % 10_007) + (f(n - 2) % 10_007)) % 10_007;
        return d[n];
    }
}
