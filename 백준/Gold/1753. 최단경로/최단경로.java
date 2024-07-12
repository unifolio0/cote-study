import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());
        List<Node>[] graph = new List[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(
                    new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] isVisit = new boolean[V + 1];
        queue.add(new Node(K, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!isVisit[node.end]) {
                isVisit[node.end] = true;

                for (Node nextNode : graph[node.end]) {
                    if (dist[nextNode.end] > dist[node.end] + nextNode.weight) {
                        dist[nextNode.end] = dist[node.end] + nextNode.weight;
                        queue.add(new Node(nextNode.end, dist[nextNode.end]));
                    }
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
