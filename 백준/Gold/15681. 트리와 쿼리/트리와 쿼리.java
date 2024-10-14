import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer>[] graph;
    static int[] mem;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[U].add(V);
            graph[V].add(U);
        }
        mem = new int[N + 1];
        visit = new boolean[N + 1];
        dfs(R);
        
        for (int i = 0; i < Q; i++) {
            int k = Integer.parseInt(br.readLine());
            bw.write(mem[k] + "\n");
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
    
    static public void dfs(int cur) {
        if (visit[cur]) return;
        visit[cur] = true;
        boolean leaf = true;
        for (int node : graph[cur]) {
            if (visit[node]) continue;
        
            dfs(node);
            
            mem[cur] += mem[node];
            leaf = false;
        }
        mem[cur]++;
        if (leaf) {
            mem[cur] = 1;
        }
    }
}