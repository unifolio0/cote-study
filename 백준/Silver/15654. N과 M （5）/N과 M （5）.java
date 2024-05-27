import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[] nums;
    static int[] res;
    static boolean[] isVisit;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        res = new int[M];
        isVisit = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        nums = Arrays.stream(nums).sorted().toArray();

        track(0);

        br.close();

        bw.flush();
        bw.close();
    }

    private static void track(int m) throws IOException {
        if (m == M) {
            for (int j = 0; j < m; j++) {
                bw.write(res[j] + " ");
            }
            bw.write("\n");
        } else {
            for (int j = 0; j < N; j++) {
                if (!isVisit[j]) {
                    isVisit[j] = true;
                    res[m] = nums[j];
                    track(m + 1);
                    isVisit[j] = false;
                }
            }
        }
    }
}
