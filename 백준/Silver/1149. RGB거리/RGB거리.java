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

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < N; i++) {
            board[i][0] += Math.min(board[i - 1][1], board[i - 1][2]);
            board[i][1] += Math.min(board[i - 1][0], board[i - 1][2]);
            board[i][2] += Math.min(board[i - 1][0], board[i - 1][1]);
        }

        bw.write(String.valueOf(Math.min(Math.min(board[N - 1][0], board[N - 1][1]), board[N - 1][2])));

        br.close();

        bw.flush();
        bw.close();
    }
}
