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
        long zero = Long.MAX_VALUE;
        int f = 0;
        int g = 0;
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
//                System.out.println("i: " + i + ", start: " + start + ", end: " + end + ", mid: " + mid + ", yongak[mid]: " + yongak[mid] + ", zero: " + zero + ", yongak[i]: " + yongak[i]);
                if (i != mid) {
                    long up = yongak[i] + yongak[mid];
                    if (Math.abs(up) < Math.abs(zero)) {
                        zero = up;
                        f = Math.min(i, mid);
                        g = Math.max(i, mid);
                    }
                }
                if (yongak[i] + yongak[mid] == 0) {
                    break;
                }
                if (yongak[i] + yongak[mid] > 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        bw.write(yongak[f] + " " + yongak[g]);

        br.close();

        bw.flush();
        bw.close();
    }
}
