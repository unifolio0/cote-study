import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int presum[][];
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] park = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                park[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        presum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                presum[i][j] = park[i][j] + presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1];
            }
        }
        int k = Integer.MAX_VALUE;
        for (int i = a; i <= N; i++) {
            for (int j = b + c; j <= M; j++) {
                k = Math.min(k, cal(i, j, i - a, j - b - c));
            }
        }
        
        for (int i = a + b; i <= N; i++) {
            for (int j = a + c; j <= M; j++) {
                k = Math.min(k, cal(i, j, i - b, j - a) + cal(i - b, j - a, i - a - b, j - a - c));
            }
        }
        
        for (int i = a + c; i <= N; i++) {
            for (int j = a + b; j <= M; j++) {
                k = Math.min(k, cal(i, j, i - c, j - a) + cal(i - c, j - a, i - a - c, j - a - b));
            }
        }
        
        bw.write(String.valueOf(k));
        
        bw.flush();
        
        bw.close();
        br.close();
    }
    
    public static int cal(int x1, int y1, int x2, int y2) {
        return presum[x1][y1] - presum[x2][y1] - presum[x1][y2] + presum[x2][y2];
    }
}