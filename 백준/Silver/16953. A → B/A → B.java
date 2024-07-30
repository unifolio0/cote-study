import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        long A = Integer.parseInt(split[0]);
        long B = Integer.parseInt(split[1]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(A, 1));
        boolean notFound = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.num * 2 <= B) {
                if (cur.num * 2 == B) {
                    bw.write(String.valueOf(cur.count + 1));
                    notFound = false;
                    break;
                }
                queue.offer(new Node(cur.num * 2, cur.count + 1));
            }
            if (cur.num * 10 + 1 <= B) {
                if (cur.num * 10 + 1 == B) {
                    bw.write(String.valueOf(cur.count + 1));
                    notFound = false;
                    break;
                }
                queue.offer(new Node(cur.num * 10 + 1, cur.count + 1));
            }
        }
        if (notFound) {
            bw.write("-1");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    static class Node {
        long num;
        long count;

        public Node(long num, long count) {
            this.num = num;
            this.count = count;
        }
    }
}
