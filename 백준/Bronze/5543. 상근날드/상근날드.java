import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int b3 = sc.nextInt();
        int co = sc.nextInt();
        int ci = sc.nextInt();

        int cheap = Math.min(b1, Math.min(b2, b3)) + Math.min(co, ci) - 50;
        System.out.println(cheap);

        br.close();

        bw.flush();
        bw.close();
    }
}
