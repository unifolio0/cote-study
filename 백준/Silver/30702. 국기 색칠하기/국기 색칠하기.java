import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] A;
    static char[][] B;
    static int N;
    static int M;
    static boolean[][] visitA;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][M];
        B = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = s.charAt(j);
            }
        }
        visitA = new boolean[N][M];
        boolean u = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visitA[i][j]) {
                    List<int[]> list = new ArrayList<>();
                    bfsA(i, j, list);
                    if (bfsB(list, B[i][j])) {
                        u = true;
                        break;
                    }
                }
            }
            if (u) {
                break;
            }
        }

        if (u) {
            bw.write("NO");
        } else {
            bw.write("YES");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static void bfsA(int i, int j, List<int[]> list) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        char op = A[i][j];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (visitA[cur[0]][cur[1]]) continue;
            visitA[cur[0]][cur[1]] = true;
            list.add(new int[]{cur[0], cur[1]});
            for (int l = 0; l < 4; l++) {
                int nx = cur[0] + dx[l];
                int ny = cur[1] + dy[l];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visitA[nx][ny]) continue;
                if (A[nx][ny] != op) continue;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    private static boolean bfsB(List<int[]> list, char b) {
        for (int[] cur : list) {
            if (B[cur[0]][cur[1]] != b) {
                return true;
            }
        }
        return false;
    }
}
