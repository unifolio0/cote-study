import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] dp = new int[11];
        dp[2] = 1;
        for (int i = 3; i < 11; i++) {
            dp[i] = (dp[i - 1] + dp[1]) + (i - 1);
        }
        bw.write(String.valueOf(dp[Integer.parseInt(br.readLine())]));

        bw.flush();
        bw.close();
    }
}
