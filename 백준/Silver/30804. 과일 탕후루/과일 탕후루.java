import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] tanghuru = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tanghuru[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int max = 0;
        int[] fruit = new int[9];
        while (right < N) {
            fruit[tanghuru[right] - 1]++;
            right++;
            while (getC(fruit) > 2) {
                fruit[tanghuru[left] - 1]--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        bw.write(String.valueOf(max));

        br.close();

        bw.flush();
        bw.close();
    }

    private static int getC(int[] fruit) {
        int c = 0;
        for (int i = 0; i < 9; i++) {
            if (fruit[i] != 0) {
                c++;
            }
        }
        return c;
    }
}
