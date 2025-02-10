import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while (true) {
            String f = br.readLine();
            if (f == null) break;
            String[] uni = f.split(" ");
            String s = uni[0];
            String t = uni[1];
            if (s.length() > t.length()) {
                check(s, t);
            } else {
                check(t, s);
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }

    private static void check(String big, String small) throws IOException {
        int idx = 0;
        for (int i = 0; i < big.length(); i++) {
            if (idx < small.length() && big.charAt(i) == small.charAt(idx)) {
                idx++;
            }
        }
        if (idx == small.length()) {
            bw.write("Yes\n");
        } else {
            bw.write("No\n");
        }
    }
}
