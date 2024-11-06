import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] cc = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 1; j < size; j++) {
                int t = Integer.parseInt(st.nextToken());
                graph[k].add(t);
                cc[t]++;
                k = t;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (cc[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            ans.add(u);
            for (int v : graph[u]) {
                if (--cc[v] == 0) {
                    q.offer(v);
                }
            }
        }
        if (ans.size() != N) {
            bw.write("0");
        } else {
            for (int i = 0; i < ans.size(); i++) {
                bw.write(ans.get(i) + "\n");
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
