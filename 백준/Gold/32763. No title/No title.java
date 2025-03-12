import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] pm = new int[N + 1];
        int[] mpm = new int[N];
        int tmp = -1;
        boolean f = true;
        for (int i = 1; i <= N - 1; i++) {
            bw.write("? " + i + " * " + (i + 1) + "\n");
            bw.flush();
            String s = br.readLine();
            if (s.equals("-")) {
                mpm[i]--;
            } else if (f && s.equals("+")) {
                mpm[i]++;
                bw.write("? " + i + " + " + (i + 1) + "\n");
                bw.flush();
                String ss = br.readLine();
                if (ss.equals("-")) {
                    pm[i]--;
                    pm[i + 1]--;
                } else {
                    pm[i]++;
                    pm[i + 1]++;
                }
                tmp = i;
                f = false;
            } else if (s.equals("+")) {
                mpm[i]++;
            }
        }
        if (f) {
            bw.write("? 1 + " + N + "\n");
            bw.flush();
            String s = br.readLine();
            if (s.equals("+")) {
                pm[1]++;
                pm[N]++;
            } else {
                pm[1]--;
                pm[N]--;
            }
            tmp = 1;
        }
        for (int i = tmp; i < N; i++) {
            if (mpm[i] > 0) {
                pm[i + 1] = pm[i];
            } else {
                pm[i + 1] = pm[i] * -1;
            }
        }
        for (int i = tmp; i > 1; i--) {
            if (mpm[i - 1] > 0) {
                pm[i - 1] = pm[i];
            } else {
                pm[i - 1] = pm[i] * -1;
            }
        }
        bw.write("! ");
        for (int i = 1; i <= N; i++) {
            if (pm[i] > 0) {
                bw.write("+ ");
            } else {
                bw.write("- ");
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
