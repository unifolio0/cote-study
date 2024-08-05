import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] game = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            game[i][0] = Integer.parseInt(st.nextToken());
            game[i][1] = Integer.parseInt(st.nextToken());
            game[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] dpMin = new int[N][3];
        int[][] dpMax = new int[N][3];
        for (int i = 0; i < 3; i++) {
            dpMin[0][i] = game[0][i];
            dpMax[0][i] = game[0][i];
        }

        for (int i = 1; i < N; i++) {
            dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]) + game[i][0];
            dpMin[i][1] = Math.min(dpMin[i - 1][0], Math.min(dpMin[i - 1][1], dpMin[i - 1][2])) + game[i][1];
            dpMin[i][2] = Math.min(dpMin[i - 1][2], dpMin[i - 1][1]) + game[i][2];
            dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]) + game[i][0];
            dpMax[i][1] = Math.max(dpMax[i - 1][0], Math.max(dpMax[i - 1][1], dpMax[i - 1][2])) + game[i][1];
            dpMax[i][2] = Math.max(dpMax[i - 1][2], dpMax[i - 1][1]) + game[i][2];
        }
        bw.write(Math.max(dpMax[N - 1][0], Math.max(dpMax[N - 1][1], dpMax[N - 1][2])) + " " + Math.min(dpMin[N - 1][0], Math.min(dpMin[N - 1][1], dpMin[N - 1][2])));

        br.close();

        bw.flush();
        bw.close();
    }
}
