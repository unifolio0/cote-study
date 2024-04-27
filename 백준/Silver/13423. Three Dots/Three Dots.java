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
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int[] X = new int[N];
            boolean[] x = new boolean[200000001];
            for (int i = 0; i < N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
                x[X[i] + 100000000] = true;
            }
            int c = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if ((X[j] + X[i]) % 2 == 0 && x[((X[j] + X[i]) / 2) + 100000000]) {
                        c++;
                    }
                }
            }
            bw.write(String.valueOf(c) + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
