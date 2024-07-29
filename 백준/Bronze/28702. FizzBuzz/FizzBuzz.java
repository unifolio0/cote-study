import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        res(A, B, C);

        br.close();

        bw.flush();
        bw.close();
    }

    private static void res(String a, String b, String c) throws IOException {
        try {
            int k = Integer.parseInt(c);
            if ((k + 1) % 3 == 0 && (k + 1) % 5 == 0) {
                bw.write("FizzBuzz");
            } else if((k + 1) % 3 == 0) {
                bw.write("Fizz");
            } else if((k + 1) % 5 == 0) {
                bw.write("Buzz");
            } else {
                bw.write(String.valueOf(k + 1));
            }
        } catch (NumberFormatException e1) {
            try {
                int k = Integer.parseInt(b);
                if ((k + 2) % 3 == 0 && (k + 2) % 5 == 0) {
                    bw.write("FizzBuzz");
                } else if((k + 2) % 3 == 0) {
                    bw.write("Fizz");
                } else if((k + 2) % 5 == 0) {
                    bw.write("Buzz");
                } else {
                    bw.write(String.valueOf(k + 2));
                }
            } catch (NumberFormatException e2) {
                try {
                    int k = Integer.parseInt(a);
                    if ((k + 3) % 3 == 0 && (k + 3) % 5 == 0) {
                        bw.write("FizzBuzz");
                    } else if((k + 3) % 3 == 0) {
                        bw.write("Fizz");
                    } else if((k + 3) % 5 == 0) {
                        bw.write("Buzz");
                    } else {
                        bw.write(String.valueOf(k + 3));
                    }
                } catch (NumberFormatException e3) {

                }
            }
        }
    }
}
