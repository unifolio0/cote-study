import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    static long[] nums;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new long[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        int imax = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
            if (nums[i] > max) {
                max = nums[i];
                imax = i;
            }
        }

        long rans = 0;
        long rsum = 0;
        int ridx = 0;
        long rcount = 0;
        while (ridx != imax && rcount != K) {
            rsum += nums[ridx];
            rcount++;
            rans = Math.max(rans, rsum + nums[ridx] * (K - rcount));
            ridx = (ridx + 1) % N;
        }
        rans = Math.max(rans, rsum + nums[ridx] * (K - rcount));

        long lans = 0;
        long lsum = 0;
        int lidx = N - 1;
        long lcount = 0;
        while (lidx != imax && lcount != K) {
            lsum += nums[lidx];
            lcount++;
            lans = Math.max(lans, lsum + nums[lidx] * (K - lcount));
            lidx = lidx - 1;
            if (lidx == -1) {
                lidx = N - 1;
            }
        }
        lans = Math.max(lans, lsum + nums[lidx] * (K - lcount));
        bw.write(String.valueOf(Math.max(rans, lans)));

        bw.flush();

        bw.close();
        br.close();
    }
}
