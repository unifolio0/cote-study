import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dist[i], 1_000_001);
        }
        for (int i = 0; i < N + 1; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            dist[u][v] = h;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
                }
            }
        }
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (dist[s][e] == 1_000_001) {
                bw.write(-1 + "\n");
            } else {
                bw.write(dist[s][e] + "\n");
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }

    static class Node {
        int end;
        int height;

        public Node(int end, int height) {
            this.end = end;
            this.height = height;
        }
    }
}
