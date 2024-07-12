import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] graph1 = new List[N + 1];
        List<Node>[] graph2 = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph1[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph1[end].add(new Node(start, weight));
            graph2[start].add(new Node(end, weight));
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(X, 0));
        int[] dist1 = new int[N + 1];
        int[] dist2 = new int[N + 1];
        Arrays.fill(dist1, 100_000_000);
        Arrays.fill(dist2, 100_000_000);
        dist1[X] = 0;
        dist2[X] = 0;

        boolean[] isVisit = new boolean[N + 1];

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (!isVisit[curNode.end]) {
                isVisit[curNode.end] = true;
                for (Node nextNode : graph1[curNode.end]) {
                    if (dist1[nextNode.end] > dist1[curNode.end] + nextNode.weight) {
                        dist1[nextNode.end] = dist1[curNode.end] + nextNode.weight;
                        queue.add(new Node(nextNode.end, dist1[nextNode.end]));
                    }
                }
            }
        }

        queue.add(new Node(X, 0));
        Arrays.fill(isVisit, false);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (!isVisit[curNode.end]) {
                isVisit[curNode.end] = true;
                for (Node nextNode : graph2[curNode.end]) {
                    if (dist2[nextNode.end] > dist2[curNode.end] + nextNode.weight) {
                        dist2[nextNode.end] = dist2[curNode.end] + nextNode.weight;
                        queue.add(new Node(nextNode.end, dist2[nextNode.end]));
                    }
                }
            }
        }

        for (int i = 0; i < N + 1; i++) {
            dist1[i] += dist2[i];
        }

        int max = -1;

        for (int i = 1; i < N + 1; i++) {
            if (max < dist1[i] && dist1[i] != 100_000_000) {
                max = dist1[i];
            }
        }

        bw.write(String.valueOf(max));

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
