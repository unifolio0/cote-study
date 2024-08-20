import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br =   new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] room = new int[R][C];
        int ax1 = 0, ax2 = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] > 0) {
                    queue.offer(new int[]{i, j});
                }
                if (room[i][j] == -1) {
                    ax2 = i;
                    ax1 = i - 1;
                }
            }
        }

        int t = 0;
        while (t < T) {
            t++;
            int[][] copyRoom = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    copyRoom[i][j] += room[i][j];
                    if (copyRoom[i][j] == -1) continue;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                        if (room[nx][ny] == -1) continue;
                        int pp = room[i][j] / 5;
                        copyRoom[nx][ny] += pp;
                        copyRoom[i][j] -= pp;
                    }
                }
            }
            room = copyRoom;
            for (int i = ax1 - 1; i > 0; i--) {
                room[i][0] = room[i - 1][0];
            }
            for (int i = 0; i < C - 1; i++) {
                room[0][i] = room[0][i + 1];
            }
            for (int i = 0; i < ax1; i++) {
                room[i][C - 1] = room[i + 1][C - 1];
            }
            for (int i = C - 1; i > 1; i--) {
                room[ax1][i] = room[ax1][i - 1];
            }
            room[ax1][1] = 0;

            for (int i = ax2 + 1; i < R - 1; i++) {
                room[i][0] = room[i + 1][0];
            }
            for (int i = 0; i < C - 1; i++) {
                room[R - 1][i] = room[R - 1][i + 1];
            }
            for (int i = R - 1; i > ax2; i--) {
                room[i][C - 1] = room[i - 1][C - 1];
            }
            for (int i = C - 1; i > 1; i--) {
                room[ax2][i] = room[ax2][i - 1];
            }
            room[ax2][1] = 0;
        }

        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                count += room[i][j];
            }
        }
        bw.write(String.valueOf(count + 2));

        br.close();

        bw.flush();
        bw.close();
    }
}
