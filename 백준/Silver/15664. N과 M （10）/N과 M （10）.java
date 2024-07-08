import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M;
    static int N;
    static int[] nums;
    static Map<Integer, Integer> a;
    static int[] res;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Integer num = Integer.parseInt(st.nextToken());
            if (a.containsKey(num)) {
                a.put(num, a.get(num) + 1);
            } else {
                a.put(num, 1);
            }
        }
        nums = a.keySet().stream().distinct().sorted().mapToInt(num -> num).toArray();

        res = new int[M];

        for (int i = 0; i < nums.length; i++) {
            a.put(nums[i], a.get(nums[i]) - 1);
            track(i, 1);
            a.put(nums[i], a.get(nums[i]) + 1);
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static void track(int i, int d) throws IOException {
        res[d - 1] = nums[i];
        if (d == M) {
            for (int j = 0; j < M; j++) {
                bw.write(res[j] + " ");
            }
            bw.write("\n");
        } else {
            for (int j = i; j < nums.length; j++) {
                if (a.get(nums[j]) > 0) {
                    a.put(nums[j], a.get(nums[j]) - 1);
                    track(j, d + 1);
                    a.put(nums[j], a.get(nums[j]) + 1);
                }
            }
        }
    }
}
