import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < N; i++) {
            int l = 0;
            int r = N - 1;
            while (l < r) {
                if (l == i) l++;
                else if (r == i) r--;
                else if (nums[l] + nums[r] == nums[i]) {
                    count++;
                    break;
                } else if (nums[l] + nums[r] < nums[i]) {
                    l++;
                } else if (nums[l] + nums[r] > nums[i]) {
                    r--;
                }
            }
        }
        bw.write(String.valueOf(count));

        bw.flush();

        bw.close();
        br.close();
    }
}
