import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K, X;
    static Queue<Integer> queue;
    static Map<Integer, List<Integer>> graph;
    static boolean[] isVisit;
    static int[] d;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new HashMap<>();
        d = new int[N + 1];
        isVisit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (!graph.containsKey(A)) {
                graph.put(A, new ArrayList<>());
            }
            if (!graph.containsKey(B)) {
                graph.put(B, new ArrayList<>());
            }
            graph.get(A).add(B);
        }
        queue = new LinkedList<>();
        queue.add(X);
        isVisit[X] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int num : graph.get(cur)) {
                if (!isVisit[num]) {
                    isVisit[num] = true;
                    d[num] = d[cur] + 1;
                    queue.add(num);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (d[i + 1] == K) {
                count++;
            }
        }
        if (count == 0) {
            bw.write(String.valueOf(-1));
        } else {
            for (int i = 0; i < N; i++) {
                if (d[i + 1] == K) {
                    bw.write((i + 1) + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
