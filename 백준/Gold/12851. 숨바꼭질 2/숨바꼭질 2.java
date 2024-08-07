import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        int[] visit = new int[100001];
        Arrays.fill(visit, 100_000_000);
        visit[N] = 0;
        int count = 0;
        int min = 100_000_000;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (min < visit[cur]) {
                break;
            }
            if (cur == K) {
                min = visit[cur];
                count++;
                continue;
            }
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = cur * 2;
                } else if (i == 1) {
                    next = cur + 1;
                } else {
                    next = cur - 1;
                }
                if (next < 0 || next > 100_000) {
                    continue;
                }
                if (visit[next] == 100_000_000) {
                    visit[next] = visit[cur] + 1;
                    queue.offer(next);
                } else if (visit[next] >= visit[cur] + 1) {
                    visit[next] = visit[cur] + 1;
                    queue.offer(next);
                }
            }
        }
        bw.write(min + "\n" + count);

        br.close();

        bw.flush();
        bw.close();
    }
}
