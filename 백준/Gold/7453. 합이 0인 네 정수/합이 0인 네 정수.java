import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            A[i] = a;
            B[i] = b;
            C[i] = c;
            D[i] = d;
        }
        int[] AB = new int[N * N];
        int[] CD = new int[N * N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx++] = C[i] + D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        long ans = 0;
        int ab = 0;
        int cd = N * N - 1;
        while (ab < N * N && cd > -1) {
            int l = AB[ab];
            int r = CD[cd];
            int tmp = l + r;
            if (tmp < 0) {
                ab++;
            } else if (tmp > 0) {
                cd--;
            } else {
                long abx = 0;
                long cdx = 0;
                while (ab < N * N && l == AB[ab]) {
                    ab++;
                    abx++;
                }
                while (cd > -1 && r == CD[cd]) {
                    cd--;
                    cdx++;
                }
                ans += abx * cdx;
            }
        }

        bw.write(String.valueOf(ans));

        br.close();

        bw.flush();
        bw.close();
    }
}
