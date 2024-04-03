import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static String res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        if (N % 2 == 0) {
            res = "1 2 ".repeat(N/2);
        } else {
            res = "1 2 ".repeat(N/2) + "3";
        }
        bw.write(res);

        br.close();

        bw.flush();
        bw.close();
    }
}
