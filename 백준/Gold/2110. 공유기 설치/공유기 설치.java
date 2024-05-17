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
        int C = Integer.parseInt(st.nextToken());
        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        int[] sortedX = Arrays.stream(x).sorted().toArray();
        int start = 1;
        int end = sortedX[N - 1] - sortedX[0];
        while (start <= end) {
            int mid = (start + end) / 2;
            int pos = 0;
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (sortedX[i] - sortedX[pos] >= mid) {
                    pos = i;
                    count++;
                }
            }
            if (count >= C) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(end));

        br.close();

        bw.flush();
        bw.close();
    }
}
