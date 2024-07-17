import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Node>[] graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost, new ArrayList<>()));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> queue = new PriorityQueue<>();
        List<Integer> froute = new ArrayList<>();
        froute.add(A);
        queue.add(new Node(A, 0, froute));
        boolean[] isVisit = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;
        Node minNode = new Node(0, Integer.MAX_VALUE, new ArrayList<>());
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (!isVisit[curNode.end]) {
                isVisit[curNode.end] = true;
                for (Node nextNode : graph[curNode.end]) {
                    if (dist[nextNode.end] > dist[curNode.end] + nextNode.cost) {
                        dist[nextNode.end] = dist[curNode.end] + nextNode.cost;
                        List<Integer> route = new ArrayList<>(curNode.route);
                        route.add(nextNode.end);
                        queue.add(new Node(nextNode.end, dist[nextNode.end], route));
                        if (nextNode.end == B && nextNode.cost < minNode.cost) {
                            minNode = new Node(nextNode.end, dist[nextNode.end], route);
                        }
                    }
                }
            }
        }
        bw.write(minNode.cost + "\n");
        bw.write(minNode.route.size() + "\n");
        for (int i = 0; i < minNode.route.size(); i++) {
            bw.write(minNode.route.get(i) + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int end;
        int cost;
        List<Integer> route;

        public Node(int end, int cost, List<Integer> route) {
            this.end = end;
            this.cost = cost;
            this.route = route;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
