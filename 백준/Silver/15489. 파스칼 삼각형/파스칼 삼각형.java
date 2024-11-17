import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] triangle = new int[R + W][R + W];
        triangle[1][1] = 1;
        for (int i = 2; i <= R + W - 1; i++) {
            for (int j = 1; j <= R + W - 1; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        long ans = 0;
        int idx = C;
        for (int i = R; i < R + W; i++) {
            idx++;
            for (int j = C; j < idx; j++) {
                ans += triangle[i][j];
            }
        }

        bw.write(String.valueOf(ans));

        bw.flush();

        bw.close();
        br.close();
    }
}
