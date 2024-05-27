import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[] nums;
    static int[] res;
    static Map<Integer, Integer> isVisit;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        res = new int[M];
        isVisit = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (isVisit.containsKey(nums[i])) {
                isVisit.put(nums[i], isVisit.get(nums[i]) + 1);
            } else {
                isVisit.put(nums[i], 1);
            }
        }
        nums = Arrays.stream(nums).distinct().sorted().toArray();

        track(0);

        br.close();

        bw.flush();
        bw.close();
    }

    private static void track(int m) throws IOException {
        if (m == M) {
            for (int j = 0; j < m; j++) {
                bw.write(res[j] + " ");
            }
            bw.write("\n");
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (isVisit.get(nums[j]) > 0) {
                    isVisit.put(nums[j], isVisit.get(nums[j]) - 1);
                    res[m] = nums[j];
                    track(m + 1);
                    isVisit.put(nums[j], isVisit.get(nums[j]) + 1);
                }
            }
        }
    }
}
