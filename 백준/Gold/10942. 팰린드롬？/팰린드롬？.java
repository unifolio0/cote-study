import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] pel = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int l = i;
                int r = j;
                boolean ok = true;
                while (l <= r) {
                    if (nums[l] != nums[r]) {
                        ok = false;
                        break;
                    }
                    l++;
                    r--;
                }
                if (ok) {
                    pel[i + 1][j + 1] = true;
                }
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            if (pel[S][E]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}