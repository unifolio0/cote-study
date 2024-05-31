import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        for (int t = 0; t < T; t++) {
            int I = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Point cur = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine(), " ");
            Point next = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (cur.equals(next)) {
                bw.write(0 + "\n");
            }
            boolean[][] isVisit = new boolean[I][I];
            Queue<Point> queue = new LinkedList<>();
            queue.add(cur);
            isVisit[cur.x][cur.y] = true;
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                for (int i = 0; i < 8; i++) {
                    if (point.x + dx[i] > -1 && point.x + dx[i] < I && point.y + dy[i] > -1 && point.y + dy[i] < I
                            && !isVisit[point.x + dx[i]][point.y + dy[i]]) {
                        Point nextPoint = point.add(dx[i], dy[i]);
                        if (nextPoint.equals(next)) {
                            bw.write(nextPoint.cnt + "\n");
                        }
                        isVisit[nextPoint.x][nextPoint.y] = true;
                        queue.add(nextPoint);
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }

    static class Point {
        int x, y, cnt;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public Point add(int dx, int dy) {
            return new Point(x + dx, y + dy, cnt + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
