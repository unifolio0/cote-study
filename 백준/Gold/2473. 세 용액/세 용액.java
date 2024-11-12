import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] yongak = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            yongak[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(yongak);
        long abs = 3_000_000_001L;
        long[] ans = new long[3];
        for (int i = 0; i < N - 2; i++) {
            int start = i + 1;
            int end = N - 1;
            while (start < end) {
                long sum = yongak[start] + yongak[i] + yongak[end];
                if (abs > Math.abs(sum)) {
                    abs = Math.abs(sum);
                    ans[0] = yongak[i];
                    ans[1] = yongak[start];
                    ans[2] = yongak[end];
                }
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            bw.write(ans[i] + " ");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
