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
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = 0;
        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    int a = 1, b = 1, c = 1, d = 1;
                    for (int I = 0; I <= i; I++) {
                        a *= A[I];
                    }
                    int J = i + 1;
                    while (J <= j) {
                        b *= A[J];
                        J++;
                    }
                    int K = j + 1;
                    while (K <= k) {
                        c *= A[K];
                        K++;
                    }
                    for (int L = k + 1; L < N; L++) {
                        d *= A[L];
                    }
                    m = Math.max(m, a + b + c + d);
                }
            }
        }

        bw.write(String.valueOf(m));

        br.close();

        bw.flush();
        bw.close();
    }
}
