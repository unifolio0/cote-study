import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(br.readLine()));
        }
        int[] D = new int[M];
        for (int i = 0; i < M; i++) {
            D[i] = Integer.parseInt(br.readLine());
        }
        List<Integer> list = A.stream().sorted().collect(Collectors.toList());
        int start = 0;
        int end = list.size() - 1;
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (nums.containsKey(list.get(i))) {
                continue;
            }
            nums.put(list.get(i), i);
        }
        for (int i = 0; i < M; i++) {
            if (!nums.containsKey(D[i])) {
                bw.write("-1\n");
            } else {
                bw.write(String.valueOf(nums.get(D[i])) + "\n");
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
