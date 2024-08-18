import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] mat;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] ret = douuu(mat, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write((ret[i][j] % 1000) + " ");
            }
            bw.write("\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static int[][] douuu(int[][] mat, long b) {
        if (b <= 1) {
            return mat;
        }
        if (b % 2 == 0) {
            int[][] douuu = douuu(mat, b / 2);
            return fk(douuu, douuu);
        } else {
            int[][] douuu = douuu(mat, (b - 1) / 2);
            return fk(fk(douuu, douuu), mat);
        }
    }

    private static int[][] fk(int[][] first, int[][] last) {
        int length = first.length;
        int[][] ret = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    ret[i][j] = (ret[i][j] + (((first[i][k] % 1000) * (last[k][j] % 1000)) % 1000)) % 1000;
                }
            }
        }
        return ret;
    }
}
