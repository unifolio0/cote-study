import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Queue<Node> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = 100_000;
        boolean[] isVisit = new boolean[max + 1];
        queue.offer(new Node(N, 0));
        int min = max;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            isVisit[node.pos] = true;
            if (node.pos == K) {
                min = Math.min(min, node.time);
            }
            if (node.pos * 2 <= max && !isVisit[node.pos * 2]) {
                queue.offer(new Node(node.pos * 2, node.time));
            }
            if (node.pos + 1 <= max && !isVisit[node.pos + 1]) {
                queue.offer(new Node(node.pos + 1, node.time + 1));
            }
            if (node.pos - 1 >= 0 && !isVisit[node.pos - 1]) {
                queue.offer(new Node(node.pos - 1, node.time + 1));
            }
        }

        bw.write(String.valueOf(min));

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
