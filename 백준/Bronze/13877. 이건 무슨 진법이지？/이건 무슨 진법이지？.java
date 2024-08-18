import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            long A = ei(strings[1]);
            long C = ep(strings[1]);
            bw.write(strings[0] + " " + A + " " + Integer.parseInt(strings[1]) + " " + C + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static long ei(String k) {
        long p = 0;
        String[] split = k.split("");
        for (int i = 0; i < split.length; i++) {
            if (Integer.parseInt(split[i]) > 7) {
                return 0;
            }
            p += (long) (Math.pow(8, split.length - i - 1) * Integer.parseInt(split[i]));
        }
        return p;
    }

    private static long ep(String k) {
        long p = 0;
        String[] split = k.split("");
        for (int i = 0; i < split.length; i++) {
            p += (long) Math.pow(16, split.length - i - 1) * Integer.parseInt(split[i]);
        }
        return p;
    }
}
