import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] board;
    static boolean[] visit;
    static int R;
    static int C;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int max = 1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new String[R][C];
        for (int i = 0; i < R; i++) {
            String[] row = br.readLine().split("");
            board[i] = row;
        }
        visit = new boolean[26];
        visit[board[0][0].charAt(0) - 'A'] = true;
        dfs(0, 0, 1);
        bw.write(String.valueOf(max));

        br.close();

        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y, int count) throws IOException {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (visit[board[nx][ny].charAt(0) - 'A']) {
                    max = Math.max(max, count);
                } else {
                    visit[board[nx][ny].charAt(0) - 'A'] = true;
                    dfs(nx, ny, count + 1);
                    visit[board[nx][ny].charAt(0) - 'A'] = false;
                }
            }
        }
    }
}
