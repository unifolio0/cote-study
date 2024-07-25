import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        List<String[]> map = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            map.add(br.readLine().split(""));
        }

        boolean KK = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map.get(i)[j].equals("K")) {
                    x = i;
                    y = j;
                    KK = true;
                }
            }
            if (KK) {
                break;
            }
        }
        int[] dx = {1, 0, -1, 1, -1, 1, 0, -1};
        int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
        boolean[][] visit = new boolean[H][W];
        visit[x][y] = true;
        int[][] dist = new int[H][W];
        for (int[] d : dist) {
            Arrays.fill(d, 1_000_000);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> node1.time - node2.time);
        queue.offer(new Node(x, y, 0));
        dist[x][y] = 0;
        boolean end = false;
        int min = 1_000_000;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                    if (map.get(nx)[ny].equals("*")) {
                        if (i < 3) {
                            min = Math.min(min, curNode.time);
                        } else {
                            min = Math.min(min, curNode.time + 1);
                        }
                        end = true;
                    }
                    if (!map.get(nx)[ny].equals("#")) {
                        if (i < 3) {
                            if (dist[nx][ny] > dist[curNode.x][curNode.y]) {
                                queue.offer(new Node(nx, ny, curNode.time));
                                dist[nx][ny] = dist[curNode.x][curNode.y];
                            }
                        } else {
                            if (dist[nx][ny] > dist[curNode.x][curNode.y] + 1) {
                                queue.offer(new Node(nx, ny, curNode.time + 1));
                                dist[nx][ny] = dist[curNode.x][curNode.y] + 1;
                            }
                        }
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        if (!end) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(min));
        }

        br.close();

        bw.flush();
        bw.close();
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
