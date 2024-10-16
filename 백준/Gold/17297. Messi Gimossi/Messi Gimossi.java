import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> re;

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());
        re = new ArrayList<>();
        re.add(5);
        re.add(13);
        String s = "Messi Gimossi";

        int idx = 2;
        while (true) {
            re.add(re.get(idx - 1) + re.get(idx - 2) + 1);
            if (re.get(idx) >= M) {
                break;
            }
            idx++;
        }
        int a = f(idx, M);
        if (a == 6) {
            bw.write("Messi Messi Gimossi");
        } else {
            bw.write(s.charAt(a - 1));
        }

        bw.flush();

        bw.close();
        br.close();
    }

    private static int f(int idx, int m) {
        if (m <= 13) {
            return m;
        }
        if (m <= re.get(idx - 1)) {
            return f(idx - 1, m);
        } else if (m == re.get(idx - 1) + 1) {
            return 6;
        } else {
            return f(idx - 2, m - re.get(idx - 1) - 1);
        }
    }
}
