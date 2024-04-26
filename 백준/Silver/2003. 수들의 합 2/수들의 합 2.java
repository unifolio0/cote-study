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
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] psum = new int[N + 1];
        psum[0] = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            psum[i + 1] = sum;
        }

        int c = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                if (psum[j] - psum[i] == M) {
                    c++;
                }
            }
        }

        bw.write(String.valueOf(c));

        br.close();

        bw.flush();
        bw.close();
    }
}
