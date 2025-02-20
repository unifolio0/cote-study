import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int num = 665;
        while (count < N) {
            num++;
            if (!String.valueOf(num).replace("666", "").equals(String.valueOf(num))) {
                count++;
            }
        }
        bw.write(String.valueOf(num));

        bw.flush();

        bw.close();
        br.close();
    }
}
