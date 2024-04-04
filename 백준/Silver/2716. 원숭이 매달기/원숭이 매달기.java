import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String dd = "";
            if (st.hasMoreTokens()) {
                dd = st.nextToken();
            }
            int count = 0;
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < dd.length(); j++) {
                if(dd.charAt(j) == ']') {
                    l.add(count);
                    count--;
                } else {
                    count++;
                }
            }
            int max = 0;
            for (int m : l) {
                if (max < m) {
                    max = m;
                }
            }
            bw.write(String.valueOf((int) Math.pow(2, max)) + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
