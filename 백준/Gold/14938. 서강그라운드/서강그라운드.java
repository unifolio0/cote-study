import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int r;
    static int[] item;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, l));
            graph[b].add(new Node(a, l));
        }
        int max = -1;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, search(i));
        }
        bw.write(String.valueOf(max));

        bw.flush();

        br.close();
        bw.close();
    }

    static int search(int start) {
        int count = 0;
        int[] visit = new int[n + 1];
        Arrays.fill(visit, 100_000_000);
        visit[start] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : graph[cur.end]) {
                if (cur.dist + next.dist > m) continue;
                if (visit[next.end] < visit[cur.end] + next.dist) continue;
                visit[next.end] = visit[cur.end] + next.dist;
                queue.offer(new Node(next.end, visit[next.end]));
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (visit[i] != 100_000_000) count += item[i];
        }
        return count;
    }

    static class Node {
        int end;
        int dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}
