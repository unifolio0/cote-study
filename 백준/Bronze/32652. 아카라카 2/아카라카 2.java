import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder S = new StringBuilder("AKARAKA");
        for (int i = 1; i < N; i++) {
            S.append("RAKA");
        }
        bw.write(S.toString());

        bw.flush();

        bw.close();
        br.close();
    }
}
