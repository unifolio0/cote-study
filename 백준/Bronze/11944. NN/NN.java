import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int M = Integer.parseInt(st.nextToken());
        if (M >= Integer.parseInt(N) * N.length()) {
            bw.write(N.repeat(Integer.parseInt(N)));
        } else {
            for (int i = 0; i < M; i++) {
                bw.write(N.charAt(i % N.length()));
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
