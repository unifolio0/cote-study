import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] L = new int[N];
        int start = 1;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, L[i]);
        }
        int answer = 0;
        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                sum += L[i] / mid;
            }
            if (sum >= M) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();

        bw.flush();
        bw.close();
    }
}
