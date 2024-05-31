import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] jump = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            jump[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[N - 1] = 1;
        for (int i = N - 2; i > -1; i--) {
            if (jump[i] == 0) {
                dp[i] = dp[i + 1] + 1;
            } else if (jump[i] + i >= N - 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i + jump[i] + 1] + 1;
            }
        }
        for (int i = 0; i < N; i++) {
            bw.write(dp[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
