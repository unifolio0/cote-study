import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        boolean[] nps = new boolean[N + 1];
        List<Integer> ps = new ArrayList<>();
        nps[0] = true;
        nps[1] = true;
        for (int i = 2; i <= N; i++) {
            if (!nps[i]) {
                for (int j = i + i; j <= N; j += i) {
                    nps[j] = true;
                }
                nums[i]++;
                ps.add(i);
            }
        }
        for (int i = 0; i < ps.size(); i++) {
            int sum = ps.get(i);
            for (int j = i + 1; j < ps.size(); j++) {
                sum += ps.get(j);
                if (sum > N) break;
                nums[sum]++;
            }
        }
        bw.write(String.valueOf(nums[N]));

        bw.flush();

        bw.close();
        br.close();
    }
}
