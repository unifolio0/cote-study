import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(br.readLine());
        int b = 1000 - a;
        int res = 0;
        int[] nums = {500, 100, 50, 10, 5, 1};
        for (int num : nums) {
            res += b / num;
            b %= num;
            if (b == 0) break;
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}