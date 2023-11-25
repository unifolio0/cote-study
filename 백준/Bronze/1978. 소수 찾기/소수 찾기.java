import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 1001;
        boolean[] che = new boolean[max];
        che[1] = true;
        for (int i = 2; i < Math.pow(max, 0.5) + 1; i++) {
            if (che[i] == false) {
                for (int j = i * 2; j < max; j += i) {
                    che[j] = true;
                }
            }
        }
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!che[Integer.parseInt(st.nextToken())]) {
                count++;
            }
        }

        bw.write(String.valueOf(count));

        br.close();

        bw.flush();
        bw.close();
    }
}