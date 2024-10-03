import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int[] fdx = {0, 0, 0, 0, -1, -2, 1, 2};
        int[] fdy = {-1, -2, 1, 2, 0, 0, 0, 0};
        int[][] map = new int[N][M];
        int x = 0;
        int y = 0;
        int notcrush = 0;
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (s[j].equals("@")) {
                    x = i;
                    y = j;
                    map[i][j] = 0;
                } else if (s[j].equals(".")) {
                    map[i][j] = 0;
                } else if (s[j].equals("#")) {
                    map[i][j] = 2;
                    notcrush++;
                } else if (s[j].equals("*")) {
                    map[i][j] = 1;
                    notcrush++;
                } else if (s[j].equals("|")) {
                    map[i][j] = -1;
                }
            }
        }
        int crush = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            int nx = x + fdx[i];
            int ny = y + fdy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if ((Math.abs(fdx[i]) == 1 || Math.abs(fdy[i]) == 1) && map[nx][ny] == -1) {
                i++;
                continue;
            }
            if (map[nx][ny] > 0) {
                map[nx][ny]--;
                if (map[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    crush++;
                    notcrush--;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] > 0) {
                     map[nx][ny]--;
                     if (map[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                        crush++;
                        notcrush--;
                    }
                }
            }
        }
        bw.write(crush + " " + notcrush);
        
        bw.flush();

        bw.close();
        br.close();
    }
}
