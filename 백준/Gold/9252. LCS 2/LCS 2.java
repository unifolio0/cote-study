import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");

        int len1 = str1.length;
        int len2 = str2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1[i - 1].equals(str2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        String[] res = new String[Math.min(len1, len2)];
        int i = len1, j = len2;
        int idx = 0;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i][j - 1]) {
                j = j - 1;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i = i - 1;
            } else {
                res[idx++] = str1[i - 1];
                i = i - 1;
                j = j - 1;
            }
        }

        bw.write(dp[len1][len2] + "\n");
        for (int k = idx - 1; k > -1; k--) {
            bw.write(res[k]);
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
