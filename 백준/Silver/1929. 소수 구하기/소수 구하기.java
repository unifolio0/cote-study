import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] np = new boolean[N + 1];
        np[1] = true;
        for (int i = 2; i < Math.sqrt(N * 1.0) + 1; i++) {
            if (!np[i]) {
                for (int j = i * 2; j < N + 1; j += i) {
                    np[j] = true;
                }
            }
        }
        for (int i = M; i < N + 1; i++) {
            if (!np[i]) {
                bw.write(i + "\n");
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
