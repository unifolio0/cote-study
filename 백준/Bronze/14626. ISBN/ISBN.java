import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < 13; i++) {
            if (S.charAt(i) == '*') {
                idx = i % 2;
                continue;
            }
            sum += i % 2 == 0 ? S.charAt(i) - '0' : (S.charAt(i) - '0') * 3;
        }
        for (int i = 0; i < 10; i++) {
            if (idx == 0) {
                if ((sum + i) % 10 == 0) {
                    bw.write(String.valueOf(i));
                    break;
                }
            } else {
                if ((i * 3 + sum) % 10 == 0) {
                    bw.write(String.valueOf(i));
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
