import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> max = new ArrayList<>();
        int as = 0;
        int bs = 0;
        while (true) {
            if (as == N || bs == M) {
                break;
            }
            int mm = 0;
            int ak = as;
            int bk = bs;
            boolean u = false;
            for (int i = as; i < N; i++) {
                for (int j = bs; j < M; j++) {
//                    System.out.println("A[i]: " + A[i] + ", B[j]: " + B[j] + ", i: " + i + ", j: " + j + ", ak: " + ak + ", bk: " + bk);
                    if (A[i] == B[j] && mm < A[i]) {
//                        System.out.println("달성!!! - A[i]: " + A[i] + ", B[j]: " + B[j] + ", i: " + i + ", j: " + j);
                        ak = i;
                        bk = j;
                        mm = A[i];
                        u = true;
                    }
                }
            }
            if (u) {
                as = ak + 1;
                bs = bk + 1;
                max.add(A[ak]);
            } else {
                as = N;
                bs = M;
            }
        }

        System.out.println(max.size());
        for (int m : max) {
            System.out.print(m + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
