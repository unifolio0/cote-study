import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][N];
        int x = 0;
        int y = 0;
        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = st[j];
                if (map[i][j].equals("F")) {
                    x = i;
                    y = j;
                }
                if (map[i][j].equals("#")) {
                    visit[i][j] = true;
                }
            }
        }
        int[] dx = {-1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, -1, 1, -1, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (visit[cur[0]][cur[1]]) continue;
            visit[cur[0]][cur[1]] = true;
            count++;
            for (int i = 0; i < 7; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) continue;
                q.offer(new int[]{nx, ny});
            }
        }
        
        bw.write(String.valueOf(count - 1));
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}