import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 2];
        A[0] = 0;
        int start = 1;
        int end = L;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        A[N + 1] = L;

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            int cha = 0;
            for (int i = 0; i < N + 2; i++) {
                if (A[i] - cha > mid) {
                    cha = A[i - 1];
                    count++;
                }
                if (A[i] - cha > mid) {
                    count = K + 1;
                    break;
                }
            }
            if (count > K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(start));

        br.close();

        bw.flush();
        bw.close();
    }
}
