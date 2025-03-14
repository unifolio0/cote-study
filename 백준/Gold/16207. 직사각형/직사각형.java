import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long ans = 0;
        long[] tmp = new long[4];
        int idx = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (idx % 2 == 0) {
                tmp[idx] = arr[i];
                idx++;
            } else {
                if (tmp[idx - 1] - arr[i] <= 1) {
                    tmp[idx] = arr[i];
                    idx++;
                } else {
                    tmp[idx - 1] = arr[i];
                }
            }
            if (idx == 4) {
                ans += tmp[1] * tmp[3];
                idx = 0;
            }
        }

        bw.write(String.valueOf(ans));

        bw.flush();

        bw.close();
        br.close();
    }
}
