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

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer> buttons = new ArrayList<>();
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                buttons.add(Integer.parseInt(st.nextToken()));
            }
        }

        int err;
        int ans = Math.abs(100 - N);
        for (int i = 0; i < 1000001; i++) {
            err = 0;
            for (Integer k : buttons) {
                if (String.valueOf(i).contains(k.toString())) {
                    err = 1;
                    break;
                }
            }
            if (err == 0) {
                ans = Math.min(ans, String.valueOf(i).length() + Math.abs(i - N));
            }
        }

        bw.write(String.valueOf(ans));

        br.close();

        bw.flush();
        bw.close();
    }
}