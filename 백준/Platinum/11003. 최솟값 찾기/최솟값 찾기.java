import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Pair> deque = new ArrayDeque<>();
        deque.offerFirst(new Pair(A[0], 0));
        bw.write(deque.getFirst().num + " ");
        for (int i = 1; i < N; i++) {
            if (i < L) {
                while (!deque.isEmpty() && deque.getLast().num > A[i]) {
                    deque.pollLast();
                }
                deque.offerLast(new Pair(A[i], i));
            } else {
                if (deque.getFirst().idx < i - L + 1) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && deque.getLast().num > A[i]) {
                    deque.pollLast();
                }
                deque.offerLast(new Pair(A[i], i));
            }
            bw.write(deque.getFirst().num + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    static class Pair {
        int num;
        int idx;

        public Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
