import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        long k = 9L * S.length();
        long N = Long.parseLong(S);

        boolean d = true;

        for (long i = N - k; i < N; i++) {
            long pre = i;
            long sum = i;
            while (pre > 0) {
                sum += pre % 10;
                pre /= 10;
            }
            if (sum == N) {
                d = false;
                bw.write(String.valueOf(i));
                break;
            }
        }

        if (d) {
            bw.write("0");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
