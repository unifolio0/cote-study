import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[][][] box;
    static List<PointXYZ> first = new ArrayList<>();
    static int H, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        first.add(new PointXYZ(i, j, k));
                    }
                }
            }
        }
        int day = bfs();

        bw.write(String.valueOf(day));

        br.close();

        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<PointXYZ> q = new LinkedList<>();
        int x, y, z, nx, ny, nz;
        int[] dx = {0,0,-1,1,0,0};
        int[] dy = {1,-1,0,0,0,0};
        int[] dz = {0,0,0,0,1,-1};
        int day = 0, d_st = 0, d_en = 0, count = 0;

        for (PointXYZ point : first) {
            q.offer(point);
            d_en++;
        }

        while (!q.isEmpty()) {
            PointXYZ point = q.poll();
            x = point.getX();
            y = point.getY();
            z = point.getZ();
            for (int i = 0; i < 6; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                nz = z + dz[i];

                if ((0 <= nx && nx < M) && (0 <= ny && ny < N) && (0 <= nz && nz < H) && box[nz][ny][nx] == 0) {
                    q.offer(new PointXYZ(nz, ny, nx));
                    box[nz][ny][nx] = 1;
                    count++;
                }
            }
            d_st++;

            if (d_st == d_en) {
                d_st = 0;
                d_en = count;
                count = 0;
                day++;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return day - 1;
    }
}

class PointXYZ {
    private int X, Y, Z;
    public PointXYZ(int z, int y, int x) {
        this.Z = z;
        this.Y = y;
        this.X = x;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return Y;
    }

    public int getZ() {
        return Z;
    }
}