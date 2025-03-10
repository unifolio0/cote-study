import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());
        BigInteger[] nums = new BigInteger[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = new BigInteger(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            nums[0] = nums[0].multiply(nums[i]);
        }
        bw.write(String.valueOf(nums[0].mod(M)));

        bw.flush();

        bw.close();
        br.close();
    }
}
