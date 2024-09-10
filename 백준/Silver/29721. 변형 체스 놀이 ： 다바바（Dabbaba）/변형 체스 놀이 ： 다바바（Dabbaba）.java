import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] X = new int[K];
        int[] Y = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        Set<Pos> a = new HashSet<>();
        for (int i = 0; i < K; i++) {
            a.add(new Pos(X[i], Y[i]));
        }
        int[] dx = {0, 0, -2, 2};
        int[] dy = {2, -2, 0, 0};
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = X[i] + dx[j];
                int ny = Y[i] + dy[j];
                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
                a.add(new Pos(nx, ny));
            }
        }

        bw.write(String.valueOf(a.size() - K));

        br.close();

        bw.flush();
        bw.close();
    }

    private static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
