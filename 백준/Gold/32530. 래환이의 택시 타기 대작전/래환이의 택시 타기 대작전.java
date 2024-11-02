import java.time.*;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<LocalTime> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ":");
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            pq.offer(LocalTime.of(hour, minute));
        }
        int count = 0;
        while (!pq.isEmpty()) {
            LocalTime time = pq.poll();
            LocalTime nextTime = time.plusMinutes(10);
            while (!pq.isEmpty()) {
                LocalTime poll = pq.poll();
                if (poll.isAfter(nextTime)) {
                    pq.offer(poll);
                    break;
                }
            }
            count++;
        }

        bw.write(String.valueOf(count));

        bw.flush();

        bw.close();
        br.close();
    }
}
