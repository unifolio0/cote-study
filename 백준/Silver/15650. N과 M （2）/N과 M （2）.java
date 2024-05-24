import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[] a;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[M];

        track(1, 0);

        br.close();

        bw.flush();
        bw.close();
    }

    private static void track(int i, int m) throws IOException {
        if (m == M) {
            for (int j = 0; j < m; j++) {
                bw.write(a[j] + " ");
            }
            bw.write("\n");
        } else if (i <= N) {
            for (int j = i; j <= N; j++) {
                a[m] = j;
                track(j + 1, m + 1);
            }
        }
    }
}
