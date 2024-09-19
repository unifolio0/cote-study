import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String string = br.readLine();
        boolean rhomb = false;
        int c = 0;
        for (int i = 0; i < string.length(); i++) {
            if (rhomb && string.charAt(i) >= 'a') {
                if (i != string.length() - 1 && rhomb && string.charAt(i + 1) >= 'a') {
                    rhomb = !rhomb;
                }
                c += 2;
            } else if (!rhomb && string.charAt(i) < 'a') {
                if (i != string.length() - 1 && !rhomb && string.charAt(i + 1) < 'a') {
                    rhomb = !rhomb;
                }
                c += 2;
            } else {
                c++;
            }
        }
        bw.write(String.valueOf(c));

        br.close();

        bw.flush();
        bw.close();
    }
}
