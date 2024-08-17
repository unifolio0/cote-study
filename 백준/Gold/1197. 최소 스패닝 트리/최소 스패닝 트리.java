import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            priorityQueue.offer(new Edge(A, B, C));
        }
        parent = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
        int cost = 0;
        for (int i = 0; i < E; i++) {
            Edge cur = priorityQueue.poll();
            if (isSameParent(cur)) {
                continue;
            }
            cost += cur.cost;
            unionNode(cur);
        }

        bw.write(String.valueOf(cost));

        br.close();

        bw.flush();
        bw.close();
    }

    private static int findParent(int num) {
        if (parent[num] == num) {
            return num;
        }
        parent[num] = findParent(parent[num]);
        return parent[num];
    }

    private static boolean isSameParent(Edge cur) {
        return findParent(cur.start) == findParent(cur.end);
    }

    private static void unionNode(Edge cur) {
        int start = findParent(cur.start);
        int end = findParent(cur.end);
        if (start != end) {
            parent[end] = start;
        }
    }

    static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
