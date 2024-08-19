import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int[][] lab = new int[N][M];
        boolean[][] firstvisit = new boolean[N][M];
        int size = N * M;
        int count = size;
        List<int[]> virus = new ArrayList<>();
        List<int[]> byuk = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virus.add(new int[]{i, j});
                    count--;
                } else if (lab[i][j] == 1) {
                    count--;
                    firstvisit[i][j] = true;
                    byuk.add(new int[]{i, j});
                }
            }
        }
        int max = -1;
        for (int i = 0; i < size; i++) {
            int x1 = i / M;
            int y1 = i % M;
            if (firstvisit[x1][y1] || lab[x1][y1] == 2) continue;
            for (int j = i + 1; j < size; j++) {
                int x2 = j / M;
                int y2 = j % M;
                if (firstvisit[x2][y2] || lab[x2][y2] == 2) continue;
                for (int k = j + 1; k < size; k++) {
                    int x3 = k / M;
                    int y3 = k % M;
                    if (firstvisit[x3][y3] || lab[x3][y3] == 2) continue;
                    boolean[][] visit = new boolean[N][M];
                    for (int l = 0; l < byuk.size(); l++) {
                        visit[byuk.get(l)[0]][byuk.get(l)[1]] = true;
                    }
                    visit[x1][y1] = true;
                    visit[x2][y2] = true;
                    visit[x3][y3] = true;
                    /*System.out.println("x1: " + x1 + ", y1: " + y1 + ", x2: " + x2 + ", y2: " + y2 + ", x3: " + x3 + ", y3: " + y3);
                    System.out.println("인 결과물");
                    for (int l = 0; l < N; l++) {
                        for (int m = 0; m < M; m++) {
                            if (visit[l][m]) {
                                System.out.print("1 ");
                            } else {
                                System.out.print("0 ");
                            }
                        }
                        System.out.println();
                    }*/
                    Queue<int[]> queue = new LinkedList<>();
                    for (int l = 0; l < virus.size(); l++) {
                        queue.offer(virus.get(l));
                    }
                    while (!queue.isEmpty()) {
                        int[] vir = queue.poll();
                        if (visit[vir[0]][vir[1]]) continue;
                        visit[vir[0]][vir[1]] = true;
                        for (int l = 0; l < 4; l++) {
                            int nx = vir[0] + dx[l];
                            int ny = vir[1] + dy[l];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if (visit[nx][ny]) continue;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    /*System.out.println("아웃 결과물");
                    for (int l = 0; l < N; l++) {
                        for (int m = 0; m < M; m++) {
                            if (visit[l][m]) {
                                System.out.print("1 ");
                            } else {
                                System.out.print("0 ");
                            }
                        }
                        System.out.println();
                    }*/
                    int s = 0;
                    for (int l = 0; l < N; l++) {
                        for (int m = 0; m < M; m++) {
                            if (!visit[l][m]) {
                                s++;
                            }
                        }
                    }
                    max = Math.max(max, s);
                }
            }
        }
        bw.write(String.valueOf(max));

        br.close();

        bw.flush();
        bw.close();
    }
}
