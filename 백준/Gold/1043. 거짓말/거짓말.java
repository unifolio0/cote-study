import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        int[] truths = new int[truthNum];
        for (int i = 0; i < truthNum; i++) {
            truths[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] a = new List[N + 1];
        List<Integer>[] b = new List[M];
        for (int i = 0; i < N + 1; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            b[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int nums = Integer.parseInt(st.nextToken());
            for (int j = 0; j < nums; j++) {
                int K = Integer.parseInt(st.nextToken());
                a[K].add(i);
                b[i].add(K);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int n : truths) {
            queue.offer(n);
        }

        while (!queue.isEmpty()) {
            Integer tr = queue.poll();
            for (int next : a[tr]) {
                if (!visit[next]) {
                    visit[next] = true;
                    for (int q : b[next]) {
                        queue.offer(q);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                count++;
            }
        }

        bw.write(String.valueOf(count));

        br.close();

        bw.flush();
        bw.close();
    }
}
