import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, d, t));
            graph[v].add(new Node(u, d, t));
        }

        int left = -1, right = 1_000_000_001;
        int maxSalmon = -1;

        while (left + 1 < right) {
            int mid = (left + right) / 2;

            if (isOk(mid)) {
                maxSalmon = mid;
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(maxSalmon);
    }

    static boolean isOk(int waitTime) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, waitTime});
        int[] minTime = new int[N + 1];
        Arrays.fill(minTime, INF);
        minTime[1] = waitTime;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int currentTime = poll[1];

            if (minTime[cur] < currentTime) {
                continue;
            }
            
            if (cur == N) {
                return true;
            }

            for (Node node : graph[cur]) {
                int next = node.to;
                int travelTime = node.length;
                int collapseTime = node.collapseTime;

                if (currentTime + travelTime <= collapseTime && currentTime + travelTime < minTime[next]) {
                    minTime[next] = currentTime + travelTime;
                    pq.offer(new int[]{next, minTime[next]});
                }
            }
        }
        return false;
    }

    static class Node {
        int to;
        int length;
        int collapseTime;

        public Node(int to, int length, int collapseTime) {
            this.to = to;
            this.length = length;
            this.collapseTime = collapseTime;
        }
    }
}
