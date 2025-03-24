import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
        int tmp = sum - 100;
        int x1 = 0, x2 = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (nums[i] + nums[j] == tmp) {
                    x1 = i;
                    x2 = j;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i == x1 || i == x2) continue;
            bw.write(nums[i] + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
