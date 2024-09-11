import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dok = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dok[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int re = 0;
        int start = 0;
        int end = 0;
        while (end < N) {
            while (end < N && sum + dok[end] <= M) {
                sum += dok[end++];
            }
            re = Math.max(re, sum);
            if (end == N) break;
            if (dok[end] > M) {
                start = end + 1;
                end++;
                sum = 0;
            } else {
                sum -= dok[start];
                start++;
            }
        }
        bw.write(String.valueOf(re));

        br.close();

        bw.flush();
        bw.close();
    }
}
