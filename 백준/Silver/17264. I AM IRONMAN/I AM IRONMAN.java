import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        Map<String, Integer> players = new HashMap<>();
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String wl = st.nextToken();
            if (wl.equals("W")) {
                players.put(name, W);
            } else {
                players.put(name, -L);
            }
        }

        int score = 0;
        boolean iron = true;
        for (int i = 0; i < N; i++) {
            String t = br.readLine();
            if (iron) {
                if (players.containsKey(t)) {
                    score = Math.max(0, score + players.get(t));
                } else {
                    score = Math.max(0, score - L);
                }
                if (score >= G) {
                    iron = false;
                }
            }
        }
        if (iron) {
            bw.write("I AM IRONMAN!!");
        } else {
            bw.write("I AM NOT IRONMAN!!");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
