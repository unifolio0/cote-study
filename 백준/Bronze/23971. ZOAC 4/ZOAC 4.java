import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main (String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = (H / (N + 1)) + (H % (N + 1) == 0 ? 0 : 1);
        int l = (W / (M + 1)) + (W % (M + 1) == 0 ? 0 : 1);

        bw.write(String.valueOf(k * l));

        bw.flush();

        bw.close();
        br.close();
    }
}
