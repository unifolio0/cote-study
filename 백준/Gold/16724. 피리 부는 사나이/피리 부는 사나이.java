import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] matrix = new String[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().split("");
        }
        int[][] visit = new int[N][M];
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] != 0) continue;
                int x = i;
                int y = j;
                List<int[]> arr = new ArrayList<>();
                while (true) {
                    visit[x][y] = idx;
                    arr.add(new int[]{x, y});
                    switch (matrix[x][y]) {
                        case "D": x++; break;
                        case "L": y--; break;
                        case "R": y++; break;
                        case "U": x--; break;
                    }
                    if (visit[x][y] != 0) {
                        if (visit[x][y] == idx) {
                            idx++;
                        } else {
                            int c = visit[x][y];
                            for (int[] a : arr) {
                                visit[a[0]][a[1]] = c;
                            }
                        }
                        break;
                    }
                }
            }
        }
        int max = visit[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (max < visit[i][j]) {
                    max = visit[i][j];
                }
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();

        bw.close();
        br.close();
    }
}
