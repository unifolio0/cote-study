import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int s;
    static int N;
    static int K;
    static int R1;
    static int R2;
    static int C1;
    static int C2;
    static List<int[]> point;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());
        point = new ArrayList<>();
        int pow = (int) Math.pow(N, s);

        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                int k = i;
                int l = j;
                point.clear();
                int idx = s;
                int ppp = pow / N;
                while (idx > 0) {
                    idx--;
                    point.add(new int[]{k, l});
                    k %= ppp;
                    l %= ppp;
                    ppp /= N;
                }
                bw.write(String.valueOf(find(pow)));
            }
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }

    public static int find(int pow) {
        int depth = 0;
        while (depth < s) {
            int p = pow / N;
            int start = p * ((N - K) / 2);
            int end = pow - (p * ((N - K) / 2)) - 1;
            if (start <= point.get(depth)[0] && point.get(depth)[0] <= end && start <= point.get(depth)[1] && point.get(depth)[1] <= end) {
                return 1;
            }
            depth++;
            pow /= N;
        }
        return 0;
    }
}
