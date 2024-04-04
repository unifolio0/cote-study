import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            int c = 1;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == c) {
                    c++;
                }
                c++;
            }
            bw.write(String.valueOf(c-1) + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
