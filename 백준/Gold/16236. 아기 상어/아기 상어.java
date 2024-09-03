import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] sea = new int[N][N];
        int sharkX = 0;
        int sharkY = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int sharkSize = 2;
        int eat = 0;
        int time = 0;
        while (true) {
            boolean[][] visit = new boolean[N][N];
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(sharkX, sharkY, 0));
            PriorityQueue<Node> pq = new PriorityQueue<>();
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (visit[cur.x][cur.y]) continue;
                visit[cur.x][cur.y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || sea[nx][ny] > sharkSize || visit[nx][ny]) continue;
                    queue.add(new Node(nx, ny, cur.count + 1));
                    if (sea[nx][ny] != 0 && sea[nx][ny] < sharkSize) {
                        pq.offer(new Node(nx, ny, cur.count + 1));
                    }
                }
            }
            if (pq.isEmpty()) {
                break;
            }
            Node next = pq.poll();
            sea[sharkX][sharkY] = 0;
            sharkX = next.x;
            sharkY = next.y;
            sea[sharkX][sharkY] = 9;
            time += next.count;
            eat++;
            if (eat == sharkSize) {
                sharkSize++;
                eat = 0;
            }
        }

        bw.write(String.valueOf(time));

        br.close();

        bw.flush();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count == o.count) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.count - o.count;
        }
    }
}
