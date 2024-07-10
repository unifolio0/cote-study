import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];
        dp[0] = drinks[0];
        if (n > 1) {
            dp[1] = drinks[0] + drinks[1];
            if (n > 2) {
                dp[2] = Math.max(dp[1], Math.max(dp[0] + drinks[2], drinks[1] + drinks[2]));
                for (int i = 3; i < n; i++) {
                    dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + drinks[i - 1]) + drinks[i]);
                }
            }
        }
        bw.write(String.valueOf(dp[n - 1]));

        br.close();

        bw.flush();
        bw.close();
    }
}
