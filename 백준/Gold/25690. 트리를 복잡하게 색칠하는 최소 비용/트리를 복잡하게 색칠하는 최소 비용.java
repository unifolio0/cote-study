import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer>[] graph;
    static int[] white;
    static int[] black;
    static long[][] cost;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        white = new int[n];
        black = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            white[i] = Integer.parseInt(st.nextToken());
            black[i] = Integer.parseInt(st.nextToken());
        }

        isVisit = new boolean[n];
        cost = new long[n][2];
        dfs(0);
        bw.write(String.valueOf(Math.min(cost[0][0], cost[0][1])));

        br.close();

        bw.flush();
        bw.close();
    }

    private static void dfs(int cur) {
        if (isVisit[cur]) {
            return;
        }
        isVisit[cur] = true;
        cost[cur][1] = white[cur];
        cost[cur][0] = black[cur];
        for (int next : graph[cur]) {
            if (isVisit[next]) {
                continue;
            }
            dfs(next);
            cost[cur][0] += cost[next][1];
            cost[cur][1] += Math.min(cost[next][1], cost[next][0]);
        }
    }
}
