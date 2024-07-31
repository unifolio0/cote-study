import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] dist1 = new int[N + 1][N + 1];
        int[][] dist2 = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist1[a][b] = 1;
            dist2[b][a] = 1;
        }
        for (int i = 0; i < N + 1; i++) {
            dist1[i][i] = 1;
            dist2[i][i] = 1;
        }
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (dist1[i][j] != 0) {
                        continue;
                    } else if (dist1[i][k] != 0 && dist1[k][j] != 0) {
                        dist1[i][j] = 1;
                    }
                    if (dist2[i][j] != 0) {
                        continue;
                    } else if (dist2[i][k] != 0 && dist2[k][j] != 0) {
                        dist2[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            int count = 0;
            for (int j = 1; j < N + 1; j++) {
                if (dist1[i][j] == 0 && dist2[i][j] == 0) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
