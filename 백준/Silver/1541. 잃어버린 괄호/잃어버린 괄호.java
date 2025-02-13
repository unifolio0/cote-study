import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String[] tokens = s.split("-");
        int ans = 0;
        String[] tmp = tokens[0].split("\\+");
        for (String k : tmp) {
            ans += Integer.parseInt(k);
        }
        for (int i = 1; i < tokens.length; i++) {
            tmp = tokens[i].split("\\+");
            int t = 0;
            for (String k : tmp) {
                t += Integer.parseInt(k);
            }
            ans -= t;
        }
        bw.write(String.valueOf(ans));

        bw.flush();

        bw.close();
        br.close();
    }
}
