import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long A;
    static long B;
    static long C;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(track(B) % C));

        br.close();

        bw.flush();
        bw.close();
    }

    private static long track(long b) {
        if (b == 1) {
            return A % C;
        } else {
            if (b % 2 == 0) {
                long res = track(b / 2) % C;
                return (res * res) % C;
            } else {
                long res = track((b - 1) / 2) % C;
                return (((res * res) % C) * (A % C)) % C;
            }
        }
    }
}
