import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[] fX = new long[1_000_001];
        long[] gX = new long[1_000_001];
        Arrays.fill(fX, 1);
        for (int i = 2; i < 1_000_001; i++) {
            for (int j = 1; i * j < 1_000_001; j++) {
                fX[i * j] += i;
            }
        }
        for (int i = 1; i < 1_000_001; i++) {
            gX[i] = gX[i - 1] + fX[i];
        }

        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(gX[num] + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
