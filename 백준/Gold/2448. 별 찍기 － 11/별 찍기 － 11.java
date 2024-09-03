import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int H = 2 * N - 1;
        char[][] map = new char[N][H];

        map[0][H / 2] = '*';
        map[1][H / 2 - 1] = '*';
        map[1][H / 2 + 1] = '*';
        map[2][H / 2 - 2] = '*';
        map[2][H / 2 - 1] = '*';
        map[2][H / 2] = '*';
        map[2][H / 2 + 1] = '*';
        map[2][H / 2 + 2] = '*';
        int h = 3;
        while (h < N) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < H; j++) {
                    if (map[i][j] == '*') {
                        map[i + h][j - h] = '*';
                        map[i + h][j + h] = '*';
                    }
                }
            }
            h *= 2;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < H; j++) {
                if (map[i][j] == '*') {
                    bw.write(map[i][j]);
                } else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
