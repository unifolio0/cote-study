import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1_000_005];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = ((dp[i - 2] % 1000000007) + (dp[i - 1] % 1000000007)) % 1000000007;
        }
        bw.write(String.valueOf(dp[N] % 1000000007));

        br.close();

        bw.flush();
        bw.close();
    }
}
