import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] p = new int[N];
        int[] q = new int[N];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            q[i] = Integer.parseInt(st.nextToken());
            pq.offer(new Point(i, p[i] - q[i]));
        }
        long ans = 0;
        for (int i = 0; i < A; i++) {
            ans += p[pq.poll().idx];
        }
        for (int i = 0; i < B; i++) {
            ans += q[pq.poll().idx];
        }
        bw.write(String.valueOf(ans));

        bw.flush();

        bw.close();
        br.close();
    }

    static class Point implements Comparable<Point> {
        int idx;
        int sub;

        Point(int idx, int sub) {
            this.idx = idx;
            this.sub = sub;
        }

        @Override
        public int compareTo(Point o) {
            return sub - o.sub;
        }
    }
}
