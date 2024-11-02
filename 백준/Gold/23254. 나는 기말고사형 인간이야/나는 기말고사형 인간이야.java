import java.time.*;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) * 24;
        int M = Integer.parseInt(st.nextToken());
        int[] a = new int[M];
        st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < M; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            ans += a[i];
        }
        int[] b = new int[M];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            for (int j = a[i]; j + b[i] <= 100; j += b[i]) {
                pq.offer(b[i]);
            }
            pq.offer((100 - a[i]) % b[i]);
        }
        int n = 0;
        while (!pq.isEmpty() && n < N) {
            n++;
            ans += pq.poll();
        }

        bw.write(String.valueOf(ans));

        bw.flush();

        bw.close();
        br.close();
    }
}
