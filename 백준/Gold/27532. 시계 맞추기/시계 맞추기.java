import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());
        int[] times = new int[1500];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            String[] time = s.split(":");
            int m = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            times[i] = m % 720;
        }
        for (int R = 0; R < 720; R++) {
            boolean[] visited = new boolean[720];
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                int t = (times[i] - (R * i) % 720 + 720) % 720;
                if (!visited[t]) {
                    visited[t] = true;
                    cnt++;
                }
            }
            res = Math.min(res, cnt);
        }

        bw.write(String.valueOf(res));
        bw.flush();

        bw.close();
        br.close();
    }
}
