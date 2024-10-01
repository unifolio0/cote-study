import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        long[] X = new long[N];
        long[] Y = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        long f = 0;
        long s = 0;
        for (int i = 0; i < N; i++) {
            f += X[i] * Y[(i + 1) % N];
            s += Y[i] * X[(i + 1) % N];
        }
        bw.write(String.valueOf(String.format("%.1f", Math.abs(f - s) / 2.0)));
        
        br.close();

        bw.flush();
        bw.close();
    }
}