import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][][] isVisit = new boolean[N][M][K + 1];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, 1));
        isVisit[0][0][0] = true;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {-1, 0, 0, 1};
        int min = -1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == N - 1 && node.y == M - 1) {
                min = node.pos;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !isVisit[nx][ny][node.byuk]) {
                    if (node.byuk == K && map[nx][ny] == 1) {
                        continue;
                    } else if (node.byuk < K && map[nx][ny] == 1 && !isVisit[nx][ny][node.byuk + 1]) {
                        isVisit[nx][ny][node.byuk + 1] = true;
                        queue.offer(new Node(nx, ny, node.byuk + 1, node.pos + 1));
                    } else if (map[nx][ny] == 0) {
                        isVisit[nx][ny][node.byuk] = true;
                        queue.offer(new Node(nx, ny, node.byuk, node.pos + 1));
                    }
                }
            }
        }

        bw.write(String.valueOf(min));

        br.close();

        bw.flush();
        bw.close();
    }

    static class Node {
        int x;
        int y;
        int byuk;
        int pos;

        Node(int x, int y, int byuk, int pos) {
            this.x = x;
            this.y = y;
            this.byuk = byuk;
            this.pos = pos;
        }
    }
}
