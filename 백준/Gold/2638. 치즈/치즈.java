import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] mono = new int[N][M];
        Set<int[]> cheese = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mono[i][j] = Integer.parseInt(st.nextToken());
                if (mono[i][j] == 1) {
                    cheese.add(new int[]{i, j});
                }
            }
        }
        int time = 0;
        while (!cheese.isEmpty()) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            mono[0][0] = -1;
            boolean[][] visit = new boolean[N][M];
            int[] dx = {0, 0, -1, 1};
            int[] dy = {1, -1, 0, 0};
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (visit[cur[0]][cur[1]]) continue;
                visit[cur[0]][cur[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] || mono[nx][ny] == 1) continue;
                    mono[nx][ny] = -1;
                    queue.offer(new int[]{nx, ny});
                }
            }
            Set<int[]> re = new HashSet<>();
            for (int[] ch : cheese) {
                int c = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = ch[0] + dx[i];
                    int ny = ch[1] + dy[i];
                    if (mono[nx][ny] == -1) c++;
                }
                if (c >= 2) {
                    re.add(ch);
                }
            }
            for (int[] w : re) {
                mono[w[0]][w[1]] = -1;
            }
            cheese.removeAll(re);
            time++;
        }

        bw.write(String.valueOf(time));

        bw.flush();

        br.close();
        bw.close();
    }
}
