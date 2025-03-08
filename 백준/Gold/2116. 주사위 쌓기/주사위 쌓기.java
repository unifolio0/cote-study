import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] dice = new int[N][6];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int t = 0; t < 6; t++) {
            int d = t;
            int u = f(d);
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                int k = 0;
                for (int j = 0; j < 6; j++) {
                    if (j == d || j == u) continue;
                    k = Math.max(k, dice[i][j]);
                }
                tmp += k;
                if (i == N - 1) continue;
                for (int j = 0; j < 6; j++) {
                    if (dice[i][u] == dice[i + 1][j]) {
                        d = j;
                        u = f(d);
                        break;
                    }
                }
            }
            max = Math.max(max, tmp);
        }
        bw.write(String.valueOf(max));

        bw.flush();

        bw.close();
        br.close();
    }

    public static int f(int a) {
        switch (a) {
            case 0 : return 5;
            case 1 : return 3;
            case 2 : return 4;
            case 3 : return 1;
            case 4 : return 2;
            case 5 : return 0;
            default : return a;
        }
    }
}
