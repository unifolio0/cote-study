import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String Q = st.nextToken();

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (Q.charAt(i) == 'p') {
                if (i + 3 < N && Q.charAt(i + 1) == 'P' && Q.charAt(i + 2) == 'A' && Q.charAt(i + 3) == 'p') {
                    count++;
                    i += 3;
                }
            }
        }

        bw.write(String.valueOf(count));

        br.close();

        bw.flush();
        bw.close();
    }
}
