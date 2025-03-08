import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sub = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sub[i] = Integer.parseInt(st.nextToken());
        }
        int[][] sugang = new int[N][M + 1];
        boolean[][] visit = new boolean[N][M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) break;
                sugang[i][a]++;
            }
        }
        for (int i = 1; i <= M; i++) {
            int tmp = 0;
            for (int j = 0; j < N; j++) {
                tmp += sugang[j][i];
            }
            if (tmp <= sub[i]) {
                for (int j = 0; j < N; j++) {
                    if (sugang[j][i] > 0) {
                        visit[j][i] = true;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) break;
                sugang[i][a]++;
            }
        }
        for (int i = 1; i <= M; i++) {
            int tmp = 0;
            for (int j = 0; j < N; j++) {
                tmp += sugang[j][i];
            }
            if (tmp <= sub[i]) {
                for (int j = 0; j < N; j++) {
                    if (sugang[j][i] > 0) {
                        visit[j][i] = true;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            boolean mang = true;
            for (int j = 1; j <= M; j++) {
                if (visit[i][j]) {
                    bw.write(j + " ");
                    mang = false;
                }
            }
            if (mang) {
                bw.write("망했어요");
            }
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
