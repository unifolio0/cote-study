import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int i = 1; i <= 12; i++) {
                String m = String.valueOf(i);
                boolean pass = false;
                for (int j = 0; j < m.length(); j++) {
                    if (nums[m.charAt(j) - '0'] == 1) {
                        pass = true;
                        break;
                    }
                }
                if (pass) continue;
                for (int j = 1; j <= months[i]; j++) {
                    String d = String.valueOf(j);
                    pass = false;
                    for (int k = 0; k < d.length(); k++) {
                        if (nums[d.charAt(k) - '0'] == 1) {
                            pass = true;
                            break;
                        }
                    }
                    if (pass) continue;
                    count++;
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
