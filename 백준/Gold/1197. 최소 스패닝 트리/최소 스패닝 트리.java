import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Node>[] graph = new List[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }
        boolean[] visit = new boolean[V + 1];
        int cost = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        priorityQueue.offer(new Node(1, 0));
        while (!priorityQueue.isEmpty()) {
            Node cur = priorityQueue.poll();
            if (visit[cur.end]) {
                continue;
            }
            visit[cur.end] = true;
            cost += cur.cost;
            for (Node next : graph[cur.end]) {
                if (!visit[next.end]) {
                    priorityQueue.add(next);
                }
            }
        }

        bw.write(String.valueOf(cost));

        br.close();

        bw.flush();
        bw.close();
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
