import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] x = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[N];
            Arrays.fill(dp, -1001);
            for (int i = 0; i < N; i++) {
                int sum = x[i];
                dp[i] = Math.max(dp[i], sum);
                for (int j = i + 1; j < N; j++) {
                    sum += x[j];
                    dp[j] = Math.max(dp[j], sum);
                }
            }
            int asInt = Arrays.stream(dp).max().getAsInt();
            bw.write(asInt + "\n");
        }

        bw.flush();
        bw.close();
    }
}
