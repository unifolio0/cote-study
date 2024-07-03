import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] total = new int[10];
        total[0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            total[i] = total[i - 1] + a;
        }

        int idx = 9;
        for (int i = 0; i < 9; i++) {
            if (Math.abs(total[i] - 100) < Math.abs(total[i + 1] - 100)) {
                idx = i;
                break;
            }
        }

        bw.write(String.valueOf(total[idx]));

        br.close();

        bw.flush();
        bw.close();
    }
}
