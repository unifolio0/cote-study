import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static boolean[][] visit;
    static int[][] map;
    static int[][] solved;
    static int[][] gro;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int c = 0;
    static List<int[]> q = new ArrayList<>();
    static int idx = 1;
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];
        map = new int[N][M];
        gro = new int[N][M];
        solved = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                if (map[i][j] == 1) {
                    solved[i][j] = 1;
                    visit[i][j] = true;
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) {
                    continue;
                }
                c = 0;
                q = new ArrayList<>();
                dfs(i, j);
                for (int[] n : q) {
                    solved[n[0]][n[1]] = c;
                    gro[n[0]][n[1]] = idx;
                }
                idx++;
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int tmp = 0;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1 || set.contains(gro[nx][ny])) {
                            continue;
                        }
                        set.add(gro[nx][ny]);
                        tmp += solved[nx][ny];
                    }
                    bw.write(String.valueOf((tmp + 1) % 10));
                } else {
                    bw.write("0");
                }
            }
            bw.write("\n");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
    
    public static void dfs(int x, int y) {
        if (visit[x][y]) return;
        visit[x][y] = true;
        c++;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
        q.add(new int[]{x, y});
    }
}