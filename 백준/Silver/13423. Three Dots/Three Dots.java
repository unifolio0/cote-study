import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            Map<Integer, Boolean> X = new HashMap<>();
            for (int i = 0; i < N; i++) {
                X.put(Integer.parseInt(st.nextToken()), true);
            }
            int c = 0;
            List<Integer> list = X.keySet().stream().collect(Collectors.toList());
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int a = list.get(i) + list.get(j);
                    if (a % 2 == 0 && X.containsKey(a / 2)) {
                        c++;
                    }
                }
            }
            bw.write(String.valueOf(c) + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
