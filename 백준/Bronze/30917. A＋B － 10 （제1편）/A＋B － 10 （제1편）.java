import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        for (int i = 1; i <= 9; i++) {
            System.out.println("? A " + i + "\n");
            int t = sc.nextInt();
            if (t == 1) {
                a = i;
                break;
            }
        }
        for (int i = 1; i <= 9; i++) {
            System.out.println("? B " + i + "\n");
            int t = sc.nextInt();
            if (t == 1) {
                b = i;
                break;
            }
        }
        System.out.println("! " + (a + b));
    }
}
