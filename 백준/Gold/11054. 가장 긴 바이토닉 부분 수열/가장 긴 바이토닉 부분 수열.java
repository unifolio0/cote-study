import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] dpLis = new int[N];
        int[] dpLds = new int[N];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dpLis[i] = Math.max(dpLis[i], dpLis[j] + 1);
                }
            }
        }
        for (int i = N - 2; i > -1; i--) {
            for (int j = N - 1; j > i; j--) {
                if (A[i] > A[j]) {
                    dpLds[i] = Math.max(dpLds[i], dpLds[j] + 1);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dpLis[i] + dpLds[i]);
        }
        bw.write(String.valueOf(max + 1));

        br.close();

        bw.flush();
        bw.close();
    }
}
