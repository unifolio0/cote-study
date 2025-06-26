import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int res = 0;

    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        String T = br.readLine();
        dfs(S, T);

        bw.write(String.valueOf(res));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                res = 1;
            }
            return;
        }
        if (t.charAt(t.length() - 1) == 'A') {
            dfs(s, t.substring(0, t.length() - 1));
        }
        if (t.charAt(0) == 'B') {
            StringBuffer sb = new StringBuffer(t.substring(1));
            dfs(s, sb.reverse().toString());
        }
    }
}
