import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int k;
    static List<Edu> edus;
    static int count;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        edus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            edus.add(new Edu(d, s, e));
        }
        for (int i = 0; i < n; i++) {
            Edu edu = edus.get(i);
            if (edu.day == 5) continue;
            if (edu.score > k) continue;
            if (edu.score == k) {
                count++;
                continue;
            }
            boolean[][] sc = new boolean[6][11];
            for (int j = edu.start; j <= edu.end; j++) {
                sc[edu.day][j] = true;
            }
            int sum = edu.score;
            bt(sum, i, sc);
        }
        bw.write(String.valueOf(count));

        br.close();

        bw.flush();
        bw.close();
    }

    private static void bt(int sum, int i, boolean[][] sc) {
        for (int j = i + 1; j < n; j++) {
            Edu edu = edus.get(j);
            if (edu.day == 5) continue;
            if (sum + edu.score > k) continue;
            boolean[][] sss = new boolean[6][11];
            for (int l = 0; l < 6; l++) {
                System.arraycopy(sc[l], 0, sss[l], 0, 11);
            }
            boolean v = false;
            for (int o = edu.start; o <= edu.end; o++) {
                if (sss[edu.day][o]) {
                    v = true;
                    break;
                }
                sss[edu.day][o] = true;
            }
            if (v) continue;
            if (sum + edu.score == k) {
                count++;
                continue;
            }
            bt(sum + edu.score, j, sss);
        }
    }

    static class Edu {
        int day;
        int start;
        int end;
        int score;

        public Edu(int day, int start, int end) {
            this.day = day;
            this.start = start;
            this.end = end;
            this.score = end - start + 1;
        }
    }
}

