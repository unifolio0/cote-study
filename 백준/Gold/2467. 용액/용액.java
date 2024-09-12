import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] yongak = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            yongak[i] = Integer.parseInt(st.nextToken());
        }
        int zero = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int start = 0;
        int end = N - 1;
        while (start < end) {
            if (Math.abs(yongak[start] + yongak[end]) < Math.abs(zero)) {
                l = start;
                r = end;
                zero = yongak[start] + yongak[end];
            }
            int sum = yongak[start] + yongak[end];
            if (sum == 0) {
                break;
            }
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        bw.write(yongak[l] + " " + yongak[r]);

        br.close();

        bw.flush();
        bw.close();
    }
}
