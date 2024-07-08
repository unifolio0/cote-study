import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M;
    static int N;
    static int[] a;
    static boolean[] isVisit;
    static int[] res;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i + 1;
        }
        isVisit = new boolean[N];
        res = new int[M];

        for (int i = 0; i < N; i++) {
            isVisit[i] = true;
            track(i, 1);
            isVisit[i] = false;
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static void track(int i, int d) throws IOException {
        res[d - 1] = a[i];
        if (d == M) {
            for (int j = 0; j < M; j++) {
                bw.write(res[j] + " ");
            }
            bw.write("\n");
        } else {
            for (int j = 0; j < N; j++) {
                if (!isVisit[j]) {
                    isVisit[j] = true;
                    track(j, d + 1);
                    isVisit[j] = false;
                }

            }
        }
    }
}
