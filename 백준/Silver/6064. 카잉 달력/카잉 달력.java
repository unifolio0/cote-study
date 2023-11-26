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

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int M, N, x, y, err;

        for (int t = 0; t < T; t++) {
            err = 0;
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            while (x <= M * N) {
                if ((x - y) % N == 0) {
                    bw.write(String.valueOf(x) + "\n");
                    err = 1;
                    break;
                }
                x += M;
            }
            
            if (err == 0) {
                bw.write("-1\n");
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}