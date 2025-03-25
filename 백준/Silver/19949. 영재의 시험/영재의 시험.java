import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;

    public static void main(String[] args) throws IOException {
        int[] nums = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= 5; i++) {
            int[] tmp = new int[10];
            tmp[0] = i;
            f(1, tmp, nums);
        }
        bw.write(String.valueOf(count));

        bw.flush();

        bw.close();
        br.close();
    }

    private static void f(int d, int[] tmp, int[] nums) {
        if (d == 10) {
            for (int i = 0; i < 8; i++) {
                if (tmp[i] == tmp[i + 1] && tmp[i + 1] == tmp[i + 2]) {
                    return;
                }
            }
            int r = 0;
            for (int i = 0; i < 10; i++) {
                if (tmp[i] == nums[i]) {
                    r++;
                }
            }
            if (r >= 5) count++;
            return;
        }
        for (int i = 1; i <= 5; i++) {
            tmp[d] = i;
            f(d + 1, tmp, nums);
        }
    }
}
