import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Sin> sins = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            sins.add(new Sin(x, t, s));
        }
        sins.sort((s1, s2) -> s1.x - s2.x);
        long time = 0;
        int pos = 0;
        for (int i = 0; i < k; i++) {
            time += sins.get(i).x - pos;
            if (sins.get(i).s > time) {
                time += sins.get(i).s - time;
            } else {
                long i2 = time - sins.get(i).s;
                time += ((i2 / sins.get(i).t) % 2) * (sins.get(i).t - (i2 % sins.get(i).t));
            }
            pos = sins.get(i).x;
        }
        time += n - pos;
        bw.write(String.valueOf(time));

        br.close();

        bw.flush();
        bw.close();
    }

    static class Sin {
        int x;
        int t;
        int s;

        public Sin(int x, int t, int s) {
            this.x = x;
            this.t = t;
            this.s = s;
        }
    }
}
