import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<A> as = new ArrayList<>();
        long max = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            as.add(new A(a, b, c));
            max = Math.max(max, b);
        }
        long l = 0;
        long r = max + 1;
        while (l + 1 < r) {
            long mid = (l + r) / 2;
            long ans = getAns(as, mid);
            if (ans % 2 == 0) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (l == max) {
            bw.write("NOTHING");
        } else {
            bw.write(r + " " + (getAns(as, r) - getAns(as, r - 1)));
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static long getAns(List<A> as, long mid) {
        long ans = 0;
        for (A a : as) {
            if (a.start <= mid) {
                ans += (Math.min(mid, a.end) - a.start) / a.term + 1;
            }
        }
        return ans;
    }

    static class A {
        int start;
        int end;
        int term;

        public A(int start, int end, int term) {
            this.start = start;
            this.end = end;
            this.term = term;
        }
    }
}
