import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int min = 0;
        int max = 0;
        int a = 0;
        for (int i = 0; i < N; i++) {
            if (A[max] <= A[i]) {
                max = i;
            }
            if (A[min] > A[i]) {
                if (a != 0 && A[a] > A[i]) {
                    a = i;
                }
                if (a == 0) {
                    a = i;
                }
            }
            if (a != 0) {
                if (A[i] - A[a] > A[max] - A[min]) {
                    max = i;
                    min = a;
                    a = 0;
                }
            }
            bw.write(A[max] - A[min] + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
