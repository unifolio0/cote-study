import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        int NA = Integer.parseInt(A);
        String B = br.readLine();
        int NB = Integer.parseInt(B);
        String C = br.readLine();
        int NC = Integer.parseInt(C);

        bw.write((NA + NB - NC) + "\n" + (Integer.parseInt(A + B) - NC));

        br.close();

        bw.flush();
        bw.close();
    }
}
