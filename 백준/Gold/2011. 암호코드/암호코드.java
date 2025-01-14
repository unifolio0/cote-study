import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp;
    static String s;

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        dp = new int[s.length() + 1];
        Arrays.fill(dp, 1_000_001);
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            bw.write("0");
        } else {
            bw.write(String.valueOf(f(s.length())));
        }

        bw.flush();

        bw.close();
        br.close();
    }

    private static Integer f(int d) {
        if (d < 0) return 0;
        if (d == 1) return 1;
        if (dp[d] != 1_000_001) return dp[d] % 1_000_000;
        int count = 0;
        if (s.charAt(d - 1) != '0') {
            count = (count + f(d - 1)) % 1_000_000;
        }
        if (s.charAt(d - 2) != '0' && (s.charAt(d - 2) - '0') * 10 + (s.charAt(d - 1) - '0') <= 26) {
            count = (count + f(d - 2)) % 1_000_000;
        }
        dp[d] = count;
        return dp[d] % 1_000_000;
    }
}
