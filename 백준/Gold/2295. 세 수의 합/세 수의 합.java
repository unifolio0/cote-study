import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Set<Integer> sumSet = new HashSet<>();
        for (int i : nums) {
            for (int j : nums) {
                sumSet.add(i + j);
            }
        }
        int max = 0;
        for (int num : nums) {
            for (int m : nums) {
                if (sumSet.contains(num - m)) {
                    max = Math.max(max, num);
                }
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();

        bw.close();
        br.close();
    }
}
