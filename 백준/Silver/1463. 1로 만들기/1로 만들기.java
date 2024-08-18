import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] d;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        bw.write(String.valueOf(f(N)));

        br.close();

        bw.flush();
        bw.close();
    }

    private static int f(int n) {
        if (n == 1) return 0;
        if (d[n] != Integer.MAX_VALUE) return d[n];
        if (n % 3 == 0) d[n] = Math.min(d[n], f(n / 3) + 1);
        if (n % 2 == 0) d[n] = Math.min(d[n], f(n / 2) + 1);
        d[n] = Math.min(d[n], f(n - 1) + 1);
        return d[n];
    }
}
