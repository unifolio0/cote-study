import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static int[][] board;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            board = new int[N][N];
        }

        bw.write(String.valueOf(count / N));

        br.close();

        bw.flush();
        bw.close();
    }

    private static void dfs(int start, int depth) {
        if (depth == N) {
            count++;
            return;
        }
        if (board[depth][start] == 0) {
            for (int i = 0; i < N; i++) {
                board[depth][i]++;
            }
            for (int i = depth + 1; i < N; i++) {
                board[i][start]++;
            }
            for (int i = 1; depth + i < N && start - i > -1; i++) {
                board[depth + i][start - i]++;
            }
            for (int i = 1; depth + i < N && start + i < N; i++) {
                board[depth + i][start + i]++;
            }
            for (int i = 0; i < N; i++) {
                dfs(i, depth + 1);
            }
            for (int i = 0; i < N; i++) {
                board[depth][i]--;
            }
            for (int i = depth + 1; i < N; i++) {
                board[i][start]--;
            }
            for (int i = 1; depth + i < N && start - i > -1; i++) {
                board[depth + i][start - i]--;
            }
            for (int i = 1; depth + i < N && start + i < N; i++) {
                board[depth + i][start + i]--;
            }
        }
    }
}
