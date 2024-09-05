import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());
        int[] N = new int[M];
        int[] S = new int[M];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }
        long n = 0;
        for (int i = 0; i < M; i++) {
            n += ((S[i] % mod) * (Pow(N[i], mod - 2) % mod)) % mod;
            n %= mod;
        }
        bw.write(String.valueOf(n));

        br.close();

        bw.flush();
        bw.close();
    }

    private static long Pow(int st, int k) {
        if (k == 1) return st;
        if (k % 2 == 1) {
            long d = Pow(st, k / 2);
            return (((d * d) % mod) * st) % mod;
        }
        long re = Pow(st, k / 2);
        return (re * re) % mod;
    }
}
