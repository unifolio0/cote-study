import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Node>[] graph;
    static int N, M, W;

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            graph = new List[N + 1];
            for (int i = 0; i < N + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int m = 1; m <= M; m++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                graph[S].add(new Node(E, T));
                graph[E].add(new Node(S, T));
            }

            for (int w = 1; w <= W; w++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                graph[S].add(new Node(E, T * -1));
            }
            if (bellman()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static boolean bellman() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 1_000_000_000);
        dist[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (Node nextNode : graph[j]) {
                    if (dist[nextNode.end] > dist[j] + nextNode.time) {
                        dist[nextNode.end] = dist[j] + nextNode.time;
                        if (i == N - 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    static class Node {
        int end;
        int time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}
