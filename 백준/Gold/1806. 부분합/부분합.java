import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int re = Integer.MAX_VALUE;
        while (end != N) {
            while (sum < S && end < N) {
                sum += nums[end++];
            }
            while (sum >= S && start < N) {
                sum -= nums[start++];
            }
            if (start != 0 && sum + nums[start - 1] >= S) {
                re = Math.min(re, end - start + 1);
            }
        }

        if (re == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(re));
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
