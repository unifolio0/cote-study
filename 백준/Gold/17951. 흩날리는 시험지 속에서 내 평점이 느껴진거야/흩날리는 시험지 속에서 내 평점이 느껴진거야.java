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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = 0;
        int[] x = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            end += x[i];
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                sum += x[i];
                if (sum >= mid) {
                    sum = 0;
                    count++;
                }
            }
            if (count < K) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        bw.write(String.valueOf(end));

        br.close();

        bw.flush();
        bw.close();
    }
}
