import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Map<String, List<String>> graph;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String token = st.nextToken();
            graph.put(token, new ArrayList<>());
            graph.get(token).add(st.nextToken());
            graph.get(token).add(st.nextToken());
        }

        frontdfs("A");
        bw.write("\n");
        middledfs("A");
        bw.write("\n");
        backdfs("A");

        bw.flush();
        bw.close();
    }

    private static void frontdfs(String node) throws IOException {
        bw.write(node);
        if (!graph.get(node).get(0).equals(".")) {
            frontdfs(graph.get(node).get(0));
        }
        if (!graph.get(node).get(1).equals(".")) {
            frontdfs(graph.get(node).get(1));
        }
    }

    private static void middledfs(String node) throws IOException {
        if (!graph.get(node).get(0).equals(".")) {
            middledfs(graph.get(node).get(0));
        }
        bw.write(node);
        if (!graph.get(node).get(1).equals(".")) {
            middledfs(graph.get(node).get(1));
        }
    }

    private static void backdfs(String node) throws IOException {
        if (!graph.get(node).get(0).equals(".")) {
            backdfs(graph.get(node).get(0));
        }
        if (!graph.get(node).get(1).equals(".")) {
            backdfs(graph.get(node).get(1));
        }
        bw.write(node);
    }
}
