import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer[]>[] graph;
    static boolean[] isLeaf;
    static boolean[] isVisit;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        isVisit = new boolean[n + 1];
        isLeaf = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(isLeaf, true);
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[fir].add(new Integer[]{sec, cost});
            graph[sec].add(new Integer[]{fir, cost});
            isLeaf[fir] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            if (isLeaf[i]) {
                Arrays.fill(isVisit, false);
                isVisit[i] = true;
                dfs(i, 0);
            }
        }

        bw.write(String.valueOf(max));

        br.close();

        bw.flush();
        bw.close();
    }

    private static void dfs(int i, int total) {
        max = Math.max(max, total);
        for (Integer[] next : graph[i]) {
            if (!isVisit[next[0]]) {
                isVisit[next[0]] = true;
                dfs(next[0], total + next[1]);
            }
        }
    }
}
