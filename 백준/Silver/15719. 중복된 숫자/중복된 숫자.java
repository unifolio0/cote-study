import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;

    public static void main(String[] args) throws IOException {
        long N = Long.parseLong(br.readLine());
        long k = N * (N + 1) / 2;
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());
        }
        bw.write(String.valueOf(N - (k - sum)));

        bw.flush();

        bw.close();
        br.close();
    }
}
