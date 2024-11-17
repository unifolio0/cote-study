import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] t = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            t[i] = Long.parseLong(st.nextToken());
        }
        long max = Long.MIN_VALUE;
        int l, r;
        Arrays.sort(t);
        if (N % 2 == 0) {
            l = 0;
            r = N - 1;
        } else {
            max = t[N - 1];
            l = 0;
            r = N - 2;
        }
        while (l < r) {
            max = Math.max(max, t[l] + t[r]);
            l++;
            r--;
        }
        bw.write(String.valueOf(max));

        bw.flush();

        bw.close();
        br.close();
    }
}
