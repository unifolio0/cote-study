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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int avg = Arrays.stream(a).sum() / N;
        int count = 0;
        for (int i = 0; i < N; i++) {
            while (a[i] != avg) {
                if (a[i] > avg) {
                    count++;
                    a[i]--;
                    a[i + 1]++;
                }
                if (a[i] < avg) {
                    count++;
                    a[i]++;
                    a[i + 1]--;
                }
            }
        }
        bw.write(String.valueOf(count));

        br.close();

        bw.flush();
        bw.close();
    }
}
