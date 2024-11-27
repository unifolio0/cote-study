import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        boolean[] visit = new boolean[101];
        for (int i = 1; i < 10; i++) {
            visit[i] = true;
        }
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                visit[i * j] = true;
            }
        }
        int N = Integer.parseInt(br.readLine());
        if (visit[N]) bw.write("1");
        else bw.write("0");

        bw.flush();

        bw.close();
        br.close();
    }
}
