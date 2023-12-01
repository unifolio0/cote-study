import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ladder = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Map<Integer, Integer> snake = new HashMap<>();
        for (int i = 0; i <M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] game = new int[101];
        boolean[] visit = new boolean[101];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        int x, nx;
        while (!q.isEmpty()) {
            x = q.poll();
            if (x == 100) {
                bw.write(String.valueOf(game[x]));
                break;
            }
            for (int i = 1; i < 7; i++) {
                nx = x + i;
                if (nx <= 100) {
                    if (ladder.containsKey(nx)) {
                        nx = ladder.get(nx);
                    }
                    if (snake.containsKey(nx)) {
                        nx = snake.get(nx);
                    }
                    if (!visit[nx]) {
                        visit[nx] = true;
                        game[nx] = game[x] + 1;
                        q.offer(nx);
                    }
                }
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}