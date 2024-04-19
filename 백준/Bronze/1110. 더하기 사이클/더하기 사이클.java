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
        int M = N;
        int count = 0;
        do {
            count++;
            M = ((M % 10) * 10) + (((M / 10) + (M % 10)) % 10);
        } while (M != N);

        bw.write(String.valueOf(count));

        br.close();

        bw.flush();
        bw.close();
    }
}
