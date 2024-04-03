import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, Q, L, I;
    static String res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int[] list = new int[N];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken()) - 1;
            I = Integer.parseInt(st.nextToken());
            for (int j = L; j < N; j+=I) {
                list[j] = 1;
            }
        }

        int count = (int) Arrays.stream(list).filter(i -> i == 0).count();

        bw.write(String.valueOf(count));

        br.close();

        bw.flush();
        bw.close();
    }
}
