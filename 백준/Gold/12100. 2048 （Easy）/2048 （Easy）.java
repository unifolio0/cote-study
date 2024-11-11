import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int max = Integer.MIN_VALUE;
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        bw.write(String.valueOf(max));

        bw.flush();

        bw.close();
        br.close();
    }

    private static void dfs(int depth) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = board[i].clone();
        }
        for (int t = 0; t < 4; t++) {
            if (t == 0) {
                for (int x = 0; x < N; x++) {
                    int pos = 0;
                    boolean crush = false;
                    for (int y = 0; y < N; y++) {
                        if (board[x][y] != 0) {
                            if (pos == 0 && board[x][pos] == 0) {
                                board[x][pos++] = board[x][y];
                                board[x][y] = 0;
                                continue;
                            }
                            if (pos == 0 && board[x][pos] != 0) {
                                pos++;
                                continue;
                            }
                            if (board[x][pos - 1] == board[x][y] && !crush) {
                                board[x][pos - 1] *= 2;
                                board[x][y] = 0;
                                crush = true;
                                continue;
                            }
                            board[x][pos] = board[x][y];
                            if (pos != y) {
                                board[x][y] = 0;
                            }
                            crush = false;
                            pos++;
                        }
                    }
                }
            } else if (t == 1) {
                for (int x = 0; x < N; x++) {
                    int pos = N - 1;
                    boolean crush = false;
                    for (int y = N - 1; y > -1; y--) {
                        if (board[x][y] != 0) {
                            if (pos == N - 1 && board[x][pos] == 0) {
                                board[x][pos--] = board[x][y];
                                board[x][y] = 0;
                                continue;
                            }
                            if (pos == N - 1 && board[x][pos] != 0) {
                                pos--;
                                continue;
                            }
                            if (board[x][pos + 1] == board[x][y] && !crush) {
                                board[x][pos + 1] *= 2;
                                board[x][y] = 0;
                                crush = true;
                                continue;
                            }
                            board[x][pos] = board[x][y];
                            if (pos != y) {
                                board[x][y] = 0;
                            }
                            crush = false;
                            pos--;
                        }
                    }
                }
            } else if (t == 2) {
                for (int y = 0; y < N; y++) {
                    int pos = N - 1;
                    boolean crush = false;
                    for (int x = N - 1; x > -1; x--) {
                        if (board[x][y] != 0) {
                            if (pos == N - 1 && board[pos][y] == 0) {
                                board[pos--][y] = board[x][y];
                                board[x][y] = 0;
                                continue;
                            }
                            if (pos == N - 1 && board[pos][y] != 0) {
                                pos--;
                                continue;
                            }
                            if (board[pos + 1][y] == board[x][y] && !crush) {
                                board[pos + 1][y] *= 2;
                                board[x][y] = 0;
                                crush = true;
                                continue;
                            }
                            board[pos][y] = board[x][y];
                            if (pos != x) {
                                board[x][y] = 0;
                            }
                            crush = false;
                            pos--;
                        }
                    }
                }
            } else {
                for (int y = 0; y < N; y++) {
                    int pos = 0;
                    boolean crush = false;
                    for (int x = 0; x < N; x++) {
                        if (board[x][y] != 0) {
                            if (pos == 0 && board[pos][y] == 0) {
                                board[pos++][y] = board[x][y];
                                board[x][y] = 0;
                                continue;
                            }
                            if (pos == 0 && board[pos][y] != 0) {
                                pos++;
                                continue;
                            }
                            if (board[pos - 1][y] == board[x][y] && !crush) {
                                board[pos - 1][y] *= 2;
                                board[x][y] = 0;
                                crush = true;
                                continue;
                            }
                            board[pos][y] = board[x][y];
                            if (pos != x) {
                                board[x][y] = 0;
                            }
                            crush = false;
                            pos++;
                        }
                    }
                }
            }
            dfs(depth + 1);
            for (int i = 0; i < N; i++) {
                board[i] = copy[i].clone();
            }
        }
    }
}
