import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        if (N % 2 == 0) {
            bw.write("NOT POSSIBLE");
        } else {
            int l = 0;
            int r = S.length() / 2 + 1;
            int k = 0;
            boolean already = false;
            boolean ok = true;
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < S.length() / 2; i++) {
                if (S.charAt(l) != S.charAt(r)) {
                    if (already) {
                        ok = false;
                        break;
                    }
                    if (S.charAt(l + 1) != S.charAt(r)) {
                        ok = false;
                        break;
                    }
                    else {
                        l++;
                        already = true;
                    }
                }
                sb1.append(S.charAt(r));
                l++;
                r++;
            }
            if (ok) k++;

            l = 0;
            r = S.length() / 2;
            already = false;
            ok = true;
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < S.length() / 2; i++) {
                if (S.charAt(l) != S.charAt(r)) {
                    if (already) {
                        ok = false;
                        break;
                    }
                    if (S.charAt(l) != S.charAt(r + 1)) {
                        ok = false;
                        break;
                    } else {
                        r++;
                        already = true;
                    }
                }
                sb2.append(S.charAt(l));
                l++;
                r++;
            }
            if (ok) k++;

            if (k == 0) {
                bw.write("NOT POSSIBLE");
            } else if (k == 2) {
                if (sb1.toString().equals(sb2.toString())) {
                    bw.write(sb1.toString());
                } else {
                    bw.write("NOT UNIQUE");
                }
            } else {
                if (sb1.length() == S.length() / 2) {
                    bw.write(sb1.toString());
                } else {
                    bw.write(sb2.toString());
                }
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
