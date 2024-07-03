import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer[]>[] graph;
    static boolean[] isVisit;
    static int max = 0;
    static int k = -1;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        isVisit = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(st.nextToken());
            while (true) {
                int sec = Integer.parseInt(st.nextToken());
                if (sec == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                graph[fir].add(new Integer[]{sec, cost});
                graph[sec].add(new Integer[]{fir, cost});
            }
        }

        isVisit[1] = true;
        dfs(1, 0);
        Arrays.fill(isVisit, false);
        isVisit[k] = true;
        dfs(k, 0);

        bw.write(String.valueOf(max));

        br.close();

        bw.flush();
        bw.close();
    }

    private static void dfs(int i, int total) {
        if (max < total) {
            max = total;
            k = i;
        }
        for (Integer[] next : graph[i]) {
            if (!isVisit[next[0]]) {
                isVisit[next[0]] = true;
                dfs(next[0], total + next[1]);
            }
        }
    }
}
