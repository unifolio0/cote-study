import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] chingho = new String[N];
        int[] juntulyuk = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            chingho[i] = st.nextToken();
            juntulyuk[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int ch = Integer.parseInt(br.readLine());
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (ch <= juntulyuk[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            bw.write(chingho[end + 1] + "\n");
        }

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
