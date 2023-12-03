import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int sumMax = 0;
    static int N, M;
    static int[][] paper;
    static int[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = 1;
                dfs(i, j, 0, 0);
                visited[i][j] = 0;
                ex(i, j);
            }
        }

        bw.write(String.valueOf(sumMax));

        br.close();

        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y, int sum, int co) {
        sum += paper[x][y];
        if (co == 3) {
            sumMax = Math.max(sumMax, sum);
            return;
        }
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < M && visited[nx][ny] == 0) {
                visited[nx][ny] = 1;
                dfs(nx, ny, sum, co + 1);
                visited[nx][ny] = 0;
            }
        }
    }

    public static void ex(int x, int y) {
        int sum = paper[x][y];
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                sum += paper[nx][ny];
            }
        }
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                sumMax = Math.max(sumMax, sum - paper[nx][ny]);
            } else {
                sumMax = Math.max(sumMax, sum);
            }
        }
    }
}