import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if (n < 2) {
                bw.write(Math.max(board[0][0], board[1][0]) + "\n");
                continue;
            }
            board[0][1] += board[1][0];
            board[1][1] += board[0][0];
            for (int i = 2; i < n; i++) {
                board[0][i] += Math.max(board[1][i - 1], Math.max(board[0][i - 2], board[1][i - 2]));
                board[1][i] += Math.max(board[0][i - 1], Math.max(board[0][i - 2], board[1][i - 2]));
            }
            bw.write(Math.max(board[0][n - 1], board[1][n - 1]) + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
