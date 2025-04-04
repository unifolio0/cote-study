import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] scores = new int[8];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        if ((N == 1 && M == 2) || (N == 2 && M == 1)) {
            bw.write("ChongChong");
        } else {
            bw.write("GomGom");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
