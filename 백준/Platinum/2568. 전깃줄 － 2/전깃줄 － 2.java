import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));

        int[] res = new int[N];
        int[] order = new int[N];
        int idx = 0;
        res[idx] = arr[0][1];

        for (int i = 1; i < N; i++) {
            if (res[idx] < arr[i][1]) {
                res[++idx] = arr[i][1];
                order[i] = idx;
            } else {
                int start = 0;
                int end = idx;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (res[mid] > arr[i][1]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                res[start] = arr[i][1];
                order[i] = start;
            }
        }

        boolean[] visit = new boolean[N];
        bw.write((N - idx - 1) + "\n");
        if (N - idx - 1 > 0) {
            int k = idx;
            for (int i = N - 1; i > -1; i--) {
                if (order[i] == k) {
                    visit[i] = true;
                    k--;
                }
            }
            for (int i = 0; i < N; i++) {
                if (!visit[i]) {
                    bw.write(arr[i][0] + "\n");
                }
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
