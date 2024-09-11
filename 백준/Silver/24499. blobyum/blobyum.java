import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] applePie = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            applePie[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += applePie[i];
        }
        int re = sum;
        if (N == K) {
            bw.write(String.valueOf(re));
        } else {
            int start = 0;
            int end = K - 1;
            for (int i = 0; i < N; i++) {
                sum = sum - applePie[start % N] + applePie[(end + 1) % N];
                re = Math.max(re, sum);
                start++;
                end++;
            }
            bw.write(String.valueOf(re));
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
