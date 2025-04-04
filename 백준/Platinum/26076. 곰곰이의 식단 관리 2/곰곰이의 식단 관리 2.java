import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] matrix, distance;
    static final int INF = Integer.MAX_VALUE;
    static int[][] directions = {
            {0, 1}, {1, 1}, {1, 0}, {1, -1},
            {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
    };

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = INF;
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();

        for (int j = 1; j < M; j++) {
            if (matrix[0][j] == 1) {
                deque.addFirst(new int[]{0, 0, j});
                distance[0][j] = 0;
            } else {
                deque.addLast(new int[]{1, 0, j});
                distance[0][j] = 1;
            }
        }
        for (int i = 1; i < N - 1; i++) {
            if (matrix[i][M - 1] == 1) {
                deque.addFirst(new int[]{0, i, M - 1});
                distance[i][M - 1] = 0;
            } else {
                deque.addLast(new int[]{1, i, M - 1});
                distance[i][M - 1] = 1;
            }
        }

        int answer = 2;
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int d = curr[0], i = curr[1], j = curr[2];
            if (distance[i][j] < d) continue;

            for (int[] dir : directions) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                    int w = matrix[ni][nj];
                    int newDist = distance[i][j] + (w ^ 1);
                    if (distance[ni][nj] > newDist) {
                        distance[ni][nj] = newDist;
                        if (w == 1) {
                            deque.addFirst(new int[]{newDist, ni, nj});
                        } else {
                            deque.addLast(new int[]{newDist, ni, nj});
                        }
                    }
                }
            }
        }

        for (int i = 1; i < N; i++) {
            answer = Math.min(answer, distance[i][0]);
        }
        for (int j = 1; j < M - 1; j++) {
            answer = Math.min(answer, distance[N - 1][j]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
