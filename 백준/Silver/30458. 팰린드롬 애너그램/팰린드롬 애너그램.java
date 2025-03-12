import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] alp = new int[26];
        for (int i = 0; i < N; i++) {
            if (N % 2 == 1 && N / 2 == i) continue;
            alp[s.charAt(i) - 'a']++;
        }
        bw.write(f(alp));

        bw.flush();

        bw.close();
        br.close();
    }

    private static String f(int[] alp) {
        for (int num : alp) {
            if (num % 2 == 1) {
                return "No";
            }
        }
        return "Yes";
    }
}
