import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = 1;
        }
        long[] dp = new long[1001];
        dp[1] = 10;
        for (int j = 1; j < N + 1; j++) {
            for (int i = 1; i < 10; i++) {
                nums[i] = (nums[i - 1] % 10007) + (nums[i] % 10007);
            }
            dp[j] = nums[9] % 10007;
        }
        bw.write(String.valueOf(dp[N]));

        bw.flush();
        bw.close();
    }
}
