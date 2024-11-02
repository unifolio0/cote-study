import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> integerMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(a);
            pq.offer(b);
            integerMap.put(a, i + 1);
            integerMap.put(b, i + 1);
            if (max < a) {
                max = a;
            }
            if (max < b) {
                max = b;
            }
        }
        for (int i = 0; i < N - 1; i++) {
            int k = pq.poll();
            pq2.offer(k);
            if (pq.isEmpty()) {
                int size = pq2.size();
                for (int j = 0; j < size; j++) {
                    Integer poll = pq2.poll();
                    pq.offer(poll);
                }
            }
        }
        bw.write(String.valueOf(integerMap.get(pq.poll())));

        bw.flush();

        bw.close();
        br.close();
    }
}
