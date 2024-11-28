import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if (N == 2) bw.write("1");
        else if (N == 3) bw.write("3");
        else {
            bw.write(String.valueOf((N - 2) * 3 + 2));
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
