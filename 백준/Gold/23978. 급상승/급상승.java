import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] a = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long start = 1;
        long end = (long) 3e9;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = ((mid + 1) * mid) / 2 * N;
            for (int i = 0; i < N - 1; i++) {
                if (a[i] + mid > a[i + 1]) {
                    long sub = mid - (a[i + 1] - a[i]);
                    sum -= (sub * (sub + 1)) / 2;
                }
            }
            if (sum < K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(String.valueOf(end + 1));

        br.close();

        bw.flush();
        bw.close();
    }
}
