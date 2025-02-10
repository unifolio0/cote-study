import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            String[] s1 = s.split(" ");
            int k = Integer.parseInt(s1[0]);
            int[] S = new int[k];
            for (int i = 1; i <= k; i++) {
                S[i - 1] = Integer.parseInt(s1[i]);
            }
            for (int i = 0; i <= S.length - 6; i++) {
                int[] pre = new int[6];
                pre[0] = S[i];
                dfs(S, pre, i, 1);
            }
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }

    private static void dfs(int[] S, int[] pre, int idx, int d) throws IOException {
        if (d == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(pre[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = idx + 1; i < S.length; i++) {
            pre[d] = S[i];
            dfs(S, pre, i, d + 1);
        }
    }
}
