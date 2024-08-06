import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};
        int count = 0;
        Queue<Pipe> queue = new LinkedList<>();
        queue.offer(new Pipe(0, 1, 0));
        while (!queue.isEmpty()) {
            if (house[N - 1][N - 1] == 1) {
                break;
            }
            Pipe cur = queue.poll();
            if (cur.x == N - 1 && cur.y == N - 1) {
                count++;
                continue;
            }
            for (int i = 0; i < 3; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (i == 0) {
                        if (cur.sha == 1) {
                            continue;
                        }
                        if (house[nx][ny] == 0) {
                            queue.offer(new Pipe(nx, ny, 0));
                        }
                    } else if (i == 1) {
                        if (cur.sha == 0) {
                            continue;
                        }
                        if (house[nx][ny] == 0) {
                            queue.offer(new Pipe(nx, ny, 1));
                        }
                    } else {
                        if (house[nx][ny] == 0 && house[nx][ny - 1] == 0 && house[nx - 1][ny] == 0) {
                            queue.offer(new Pipe(nx, ny, 2));
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(count));

        br.close();

        bw.flush();
        bw.close();
    }

    static class Pipe {
        int x;
        int y;
        int sha;

        public Pipe(int x, int y, int sha) {
            this.x = x;
            this.y = y;
            this.sha = sha;
        }
    }
}
