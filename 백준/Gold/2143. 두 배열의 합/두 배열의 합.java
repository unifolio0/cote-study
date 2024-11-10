import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static int n;
    static int[] A;
    static int m;
    static int[] B;
    static int aSize;
    static int bSize;
    static long[] aSum;
    static long[] bSum;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        aSize = n * (n + 1) / 2;
        aSum = new long[aSize];
        bSize = m * (m + 1) / 2;
        bSum = new long[bSize];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int av = 0;
            for (int j = i; j < n; j++) {
                av += A[j];
                aSum[idx++] = av;
            }
        }
        idx = 0;
        for (int i = 0; i < m; i++) {
            int bv = 0;
            for (int j = i; j < m; j++) {
                bv += B[j];
                bSum[idx++] = bv;
            }
        }
        Arrays.sort(aSum);
        Arrays.sort(bSum);

        long ans = 0;
        for (int i = 0; i < aSize; i++) {
            long target = T - aSum[i];
            int l = -1;
            int r = bSize;
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (bSum[mid] < target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            int min = l;
            l = -1;
            r = bSize;
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (bSum[mid] <= target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            int max = l;
            ans += max - min;
        }
        bw.write(String.valueOf(ans));

        bw.flush();

        bw.close();
        br.close();
    }
}
