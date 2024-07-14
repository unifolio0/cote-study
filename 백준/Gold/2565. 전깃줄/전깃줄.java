import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    temp = B[i];
                    B[i] = B[j];
                    B[j] = temp;
                }
            }
        }

        int[] res = new int[N];
        int idx = 0;
        res[idx] = B[0];

        for (int i = 0; i < N; i++) {
            if (res[idx] < B[i]) {
                res[++idx] = B[i];
            } else {
                int start = 0;
                int end = idx;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (res[mid] > B[i]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                res[start] = B[i];
            }
        }

        bw.write(String.valueOf(N - idx - 1));

        br.close();

        bw.flush();
        bw.close();
    }
}
