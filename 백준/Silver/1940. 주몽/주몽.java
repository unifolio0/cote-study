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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        boolean[] A = new boolean[10000001];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[Integer.parseInt(st.nextToken())] = true;
        }

        int c = 0;
        for (int i = 1; i <= M / 2; i++) {
            if (A[i] && A[M - i] && i != M - i) {
                c++;
            }
        }
        bw.write(String.valueOf(c));

        br.close();

        bw.flush();
        bw.close();
    }
}
