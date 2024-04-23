import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        if (N < 100) {
            bw.write(String.valueOf(N));
        } else {
            int count = 99;
            for (int i = 100; i <= N; i++) {
                int a = i / 100;
                int b = (i % 100) / 10;
                int c = i % 10;
                if (b - a == c - b) {
                    count++;
                }
            }
            bw.write(String.valueOf(count));
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
