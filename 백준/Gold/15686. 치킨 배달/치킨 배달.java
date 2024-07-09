import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new int[]{i, j});
                    map[i][j] = Integer.MAX_VALUE;
                } else if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < chicken.size() - M + 1; i++) {
            track(i, 0, 0);
        }

        bw.write(String.valueOf(min));

        br.close();

        bw.flush();
        bw.close();
    }

    private static void track(int i, int d, int sum) {
        if (d == M) {
            min = Math.min(min, sum);
            return;
        }
        int[] predist = new int[house.size()];
        int chickenx = chicken.get(i)[0];
        int chickeny = chicken.get(i)[1];
        if (d == 0) {
            for (int j = 0; j < house.size(); j++) {
                int[] h = house.get(j);
                int dist = Math.abs(chickenx - h[0]) + Math.abs(chickeny - h[1]);
                map[h[0]][h[1]] = dist;
                sum += dist;
            }
        } else {
            for (int j = 0; j < house.size(); j++) {
                int[] h = house.get(j);
                int dist = Math.abs(chickenx - h[0]) + Math.abs(chickeny - h[1]);
                predist[j] = map[h[0]][h[1]];
                if (map[h[0]][h[1]] > dist) {
                    sum -= map[h[0]][h[1]] - dist;
                    map[h[0]][h[1]] = dist;
                }
            }
        }
        for (int j = i + 1; j < chicken.size() - M + 2 + d; j++) {
            track(j, d + 1, sum);
        }
        if (d != 0) {
            for (int k = 0; k < house.size(); k++) {
                int[] h = house.get(k);
                map[h[0]][h[1]] = predist[k];
            }
        }
    }
}
