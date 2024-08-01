import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Node>[] graph;
    static int N;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        dij(A, B);

        br.close();

        bw.flush();
        bw.close();
    }

    private static void dij(int a, int b) throws IOException {
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        dist = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(dist, 100_000_000);
        dist[a] = 0;
        queue.offer(new Node(a, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (!visit[cur.end]) {
                visit[cur.end] = true;
                for (Node nextNode : graph[cur.end]) {
                    if (dist[nextNode.end] > dist[cur.end] + nextNode.cost) {
                        dist[nextNode.end] = dist[cur.end] + nextNode.cost;
                        queue.add(new Node(nextNode.end, dist[nextNode.end]));
                    }
                }
            }
//            for (int i = 1; i < N + 1; i++) {
//                System.out.print(dist[i] + " ");
//            }
//            System.out.println();
        }
        bw.write(String.valueOf(dist[b]));
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
