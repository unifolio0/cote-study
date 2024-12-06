import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
            a[i][2] = Integer.parseInt(st.nextToken());
            
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long rr = 1l * r * r;
            int count = 0;
            for (int j = 0; j < N; j++) {
                int q = x - a[j][0];
                int w = y - a[j][1];
                int e = z - a[j][2];
                if (1l * q * q + 1l * w * w + 1l * e * e <= rr) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}