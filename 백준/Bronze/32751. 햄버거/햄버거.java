import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        String S = br.readLine();
        if (N == 1) {
            if (S.equals("a") && nums[0] > 0) {
                bw.write("Yes");
            } else {
                bw.write("No");
            }
        } else {
            if (S.charAt(0) != 'a' || S.charAt(N - 1) != 'a' || nums[0] < 2) {
                bw.write("No");
            } else {
                boolean eat = true;
                nums[0] -= 2;
                for (int i = 1; i < N - 1; i++) {
                    if (nums[S.charAt(i) - 'a'] <= 0 || S.charAt(i) == S.charAt(i - 1)) {
                        eat = false;
                        break;
                    }
                    nums[S.charAt(i) - 'a']--;
                }
                if (S.charAt(N - 2) == 'a') {
                    eat = false;
                }
                if (eat) {
                    bw.write("Yes");
                } else {
                    bw.write("No");
                }
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
