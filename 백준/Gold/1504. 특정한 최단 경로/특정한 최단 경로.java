import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Node>[] graph;
    static boolean[] visit;
    static int[] dist;
    static int u;
    static int v;
    static int N;
    static int E;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int su = dij(1, u);
        int sv = dij(1, v);
        int uv = dij(u, v);
        int ue = dij(u, N);
        int ve = dij(v, N);
        int min = Math.min((su + uv + ve), (sv + uv + ue));
        if (min >= 100_000_000) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(min));
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static int dij(int s, int e) {
        visit = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, 100_000_000);
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.offer(new Node(s, 0));
        dist[s] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visit[cur.end]) continue;
            visit[cur.end] = true;
            for (Node next : graph[cur.end]) {
                if (!visit[next.end]) {
                    dist[next.end] = Math.min(dist[next.end], dist[cur.end] + next.cost);
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
        return dist[e];
    }

    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
