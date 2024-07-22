import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<int[]>[] graph = new List[n + 1];
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new int[]{a, s});
            }

            int count = 0;
            boolean[] isVisit = new boolean[n + 1];
            PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> node1.time - node2.time);
            queue.offer(new Node(c, 0));
            isVisit[c] = true;
            count++;

            int[] times = new int[n + 1];

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                for (int[] next : graph[cur.pos]) {
                    if (!isVisit[next[0]]) {
                        isVisit[next[0]] = true;
                        Node nextNode = new Node(next[0], cur.time + next[1]);
                        queue.offer(nextNode);
                        count++;
                        times[nextNode.pos] = nextNode.time;
                    } else if (times[next[0]] > cur.time + next[1]) {
                        times[next[0]] = Math.min(times[next[0]], cur.time + next[1]);
                        queue.offer(new Node(next[0], cur.time + next[1]));
                    }
                }
            }
            long time = Arrays.stream(times).max().getAsInt();
            bw.write(count + " " + time + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    static class Node {
        int pos;
        int time;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
