import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] prices = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }
            int[] maxPrices = new int[N];
            int maxPrice = maxPrices[N - 1];
            for (int i = N - 1; i >= 0; i--) {
                maxPrice = Math.max(maxPrice, prices[i]);
                maxPrices[i] = maxPrice;
            }
            long re = 0;
            for (int i = 0; i < N; i++) {
                re += maxPrices[i] - prices[i];
            }
            bw.write(re + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
