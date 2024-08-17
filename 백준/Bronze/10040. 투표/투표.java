import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(br.readLine());
        }
        int[] cost = new int[N];
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[j] <= B[i]) {
                    cost[j]++;
                    if (cost[max] < cost[j]) {
                        max = j;
                    }
                    break;
                }
            }
        }
        bw.write(String.valueOf(max + 1));

        br.close();

        bw.flush();
        bw.close();
    }
}
