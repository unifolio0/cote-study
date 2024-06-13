import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Queue<Node> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int jcount = 0;
        boolean im = true;
        String[][] maze = new String[R][C];
        boolean[][] isVisit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String[] a = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (a[j].equals("#")) {
                    isVisit[i][j] = true;
                }
                if (a[j].equals("J")) {
                    queue.offer(new Node(i, j, "J", 0));
                    isVisit[i][j] = true;
                    jcount++;
                }
                maze[i][j] = a[j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maze[i][j].equals("F")) {
                    queue.offer(new Node(i, j, "F"));
                    isVisit[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.type.equals("J")) {
                if (maze[node.x][node.y].equals("F")) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        System.out.println(node.time + 1);
                        return;
                    }
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !isVisit[nx][ny]) {
                        jcount++;
                        isVisit[nx][ny] = true;
                        queue.offer(new Node(nx, ny, "J", node.time + 1));
                        maze[nx][ny] = "J";
                    }
                }
                maze[node.x][node.y] = ".";
                jcount--;
            }
            if (node.type.equals("F")) {
                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (maze[nx][ny].equals("J")) {
                            jcount--;
                            if (jcount == 0) {
                                System.out.println("IMPOSSIBLE");
                                return;
                            }
                            queue.offer(new Node(nx, ny, "F"));
                        }
                        if (!isVisit[nx][ny]) {
                            isVisit[nx][ny] = true;
                            queue.offer(new Node(nx, ny, "F"));
                        }
                        if (maze[nx][ny].equals(".") || maze[nx][ny].equals("J")) {
                            maze[nx][ny] = "F";
                        }
                    }
                }
            }
            if (!im) {
                break;
            }
        }

        if (im) {
            System.out.println("IMPOSSIBLE");
        }

        bw.flush();
        bw.close();
    }

    static class Node {
        int x;
        int y;
        String type;
        int time;

        public Node(int x, int y, String type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public Node(int x, int y, String type, int time) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.time = time;
        }
    }
}
