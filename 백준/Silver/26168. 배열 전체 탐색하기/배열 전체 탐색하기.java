import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        long[] SA = Arrays.stream(A).sorted().toArray();
        for (int q = 0; q < M; q++) {
            idx++;
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            if (m == 1) {
                long k = Long.parseLong(st.nextToken());
                int res = binsearch(SA, k);
                bw.write(String.valueOf(N - res) + "\n");
            } else if (m == 2) {
                long k = Long.parseLong(st.nextToken());
                int res = binsearch(SA, k);
                if (res != SA.length && SA[res] == k) {
                    res = binsearch2(SA, k);
                    bw.write(String.valueOf(N - res) + "\n");
                } else {
                    bw.write(String.valueOf(N - res) + "\n");
                }
            } else {
                long i = Long.parseLong(st.nextToken());
                long j = Long.parseLong(st.nextToken());
                int ires = binsearch(SA, i);
                int jres = binsearch2(SA, j);
                bw.write(String.valueOf(jres - ires) + "\n");
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static int binsearch(long[] sa, long k) {
        int start = 0;
        int end = sa.length - 1;
        if (k > sa[end]) {
            return end + 1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
//            System.out.println("%d. start : %d, end : %d, mid : %d".formatted(idx, start, end, mid));
            if (sa[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static int binsearch2(long[] sa, long k) {
        int start = 0;
        int end = sa.length - 1;
        if (k > sa[end]) {
            return end + 1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
//            System.out.println("%d. start : %d, end : %d, mid : %d".formatted(idx, start, end, mid));
            if (sa[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
