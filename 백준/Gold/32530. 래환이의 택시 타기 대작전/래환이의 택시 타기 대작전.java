import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ":");
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            pq.offer(hour * 60 + minute);
        }
        int count = 0;
        while (!pq.isEmpty()) {
            count++;
            int time = pq.poll();
            int nextTime = time + 20;
            int tmp = 1;
            while (!pq.isEmpty()) {
                if (pq.peek() > nextTime) {
                    break;
                }
                pq.poll();
                tmp++;
                if (tmp == 3) {
                    break;
                }
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();

        bw.close();
        br.close();
    }
}
