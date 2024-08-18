import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if (s.endsWith("***")) {
                break;
            }
            for (int i = 0; i < s.length(); i++) {
                bw.write(s.charAt(s.length() - i - 1));
            }
            bw.write("\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
