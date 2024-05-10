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
        int[] high = new int[N];
        for (int i = 0; i < N; i++) {
            high[i] = Integer.parseInt(st.nextToken());
        }
        int[] shigh = Arrays.stream(high).sorted().toArray();

        int hsize = shigh.length - 1;
        int start = 0;
        int end = shigh[hsize];
        long mid;
        while (start <= end) {
            mid = (start + end) / 2;
            long sum = 0;
            for (int i = hsize; i >= 0; i--) {
                if (shigh[i] > mid) {
                    sum += shigh[i] - mid;
                } else {
                    break;
                }
            }
            if (sum < M) {
                end = (int) (mid - 1);
            } else {
                start = (int) (mid + 1);
            }
        }

        bw.write(String.valueOf(end));

        br.close();

        bw.flush();
        bw.close();
    }
}
