import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] par;
    static Map<Integer, List<Integer>> graph;
    static boolean[] isVisit;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        isVisit = new boolean[N + 1];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        par = new int[N + 1];
        dfs(1);
        for (int i = 2; i < N + 1; i++) {
            bw.write(par[i] + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static void dfs(int i) {
        isVisit[i] = true;
        for (int num : graph.get(i)) {
            if (!isVisit[num]) {
                par[num] = i;
                dfs(num);
            }
        }
    }
}
