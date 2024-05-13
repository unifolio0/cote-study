import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        long[] A = new long[M];
        for (int i = 0; i < M; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        long[] presum = new long[M];
        presum[0] = A[0];
        for (int i = 1; i < M; i++) {
            presum[i] = presum[i - 1] + A[i];
        }

        for (int i = 0; i < N; i++) {
            long b = Long.parseLong(br.readLine());
            int start = 0;
            int end = presum.length - 1;
            if (b > presum[end]) {
                bw.write("Go away!\n");
                continue;
            }
            while (start <= end) {
                int mid = (start + end) / 2;
                if (presum[mid] < b) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            bw.write(String.valueOf(start + 1) + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
