import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Set<String> dix = new HashSet<>();
        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            dix.add(br.readLine());
        }

        for (int i = 0; i < 25; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int seq = s.charAt(j) - 'a';
                char ss = (char) ('a' + ((seq + i) % 26));
                sb.append(ss);
            }
            String k = sb.toString();
            boolean end = false;
            for (int j = 0; j < k.length(); j++) {
                for (int l = j; l < k.length(); l++) {
                    if (dix.contains(k.substring(j, l + 1))) {
                        bw.write(k);
                        end = true;
                        break;
                    }
                }
                if (end) {
                    break;
                }
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
