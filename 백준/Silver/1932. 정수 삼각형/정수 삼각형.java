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

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> sqa = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sqa.add(new ArrayList<>());
            for (int j = 0; j < i + 1; j++) {
                sqa.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = n - 1; i > 0; i--) {
            List<Integer> row = sqa.get(i);
            List<Integer> change = sqa.get(i - 1);
            for (int j = 0; j < change.size(); j++) {
                change.set(j, change.get(j) + Math.max(row.get(j), row.get(j + 1)));
            }
        }

        bw.write(String.valueOf(sqa.get(0).get(0)));

        br.close();

        bw.flush();
        bw.close();
    }
}
