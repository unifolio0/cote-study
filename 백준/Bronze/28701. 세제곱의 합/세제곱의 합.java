import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int a = N * (N + 1) / 2;
        bw.write(a + "\n");
        bw.write((a * a) + "\n");
        int sum = 0;
        for (int i = 0; i <= N; i++) {
            sum += i * i * i;
        }
        bw.write(sum + "\n");

        bw.flush();

        bw.close();
        br.close();
    }
}
