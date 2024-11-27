import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            count += A[i];
        }
        if (count % 2 == 1) bw.write("1");
        else {
            int sum = 0;
            boolean x = true;
            for (int i = 0; i < N - 1; i++) {
                sum += A[i];
                if (sum % 2 == 0) {
                    bw.write("1");
                    x = false;
                    break;
                }
            }
            if (x) {
                bw.write("0");
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
