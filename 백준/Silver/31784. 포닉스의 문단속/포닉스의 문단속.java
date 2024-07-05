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
        String S = br.readLine();
        char[] c = new char[N];

        for (int i = 0; i < N; i++) {
            c[i] = S.charAt(i);
        }

        for (int i = 0; i < N; i++) {
            if (c[i] == 'A' && i != N - 1) {
                continue;
            }
            int sub = 'Z' - c[i] + 1;
            if (K >= sub) {
                c[i] = 'A';
                K -= sub;
            }
            if (K == 0) {
                break;
            }
            if (i == N - 1) {
                K %= 26;
                if (K <= 'Z' - c[i]) {
                    c[i] = (char) (c[i] + K);
                } else {
                    int x = K - ('Z' - c[i] + 1);
                    c[i] = (char) ('A' + x);
                }
            }
        }

        bw.write(c);

        br.close();

        bw.flush();
        bw.close();
    }
}
