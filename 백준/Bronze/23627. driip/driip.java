import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        if (s.endsWith("driip")) {
            bw.write("cute");
        } else {
            bw.write("not cute");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
