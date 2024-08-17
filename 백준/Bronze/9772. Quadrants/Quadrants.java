import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double N = Double.parseDouble(st.nextToken());
            double M = Double.parseDouble(st.nextToken());
            if (N == 0 && M == 0) {
                bw.write("AXIS");
                break;
            }
            if (N > 0 && M > 0) {
                bw.write("Q1");
            } else if (N < 0 && M > 0) {
                bw.write("Q2");
            } else if (N < 0 && M < 0) {
                bw.write("Q3");
            } else if (N > 0 && M < 0) {
                bw.write("Q4");
            } else {
                bw.write("AXIS");
            }
            bw.write("\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
