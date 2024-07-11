import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Long, Long> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        dp.put(0L, 0L);
        dp.put(1L, 1L);
        dp.put(2L, 1L);

        bw.write(String.valueOf(fib(n) % 1000000007));

        br.close();

        bw.flush();
        bw.close();
    }

    private static long fib(long n) {
        if (n <= 2) {
            return dp.get(n);
        } else if (dp.containsKey(n)) {
            return dp.get(n);
        } else {
            if (n % 2 == 0) {
                long fib = fib(n / 2) % 1000000007;
                long fib1 = fib((n / 2) - 1) % 1000000007;
                long fib2 = fib((n / 2) + 1) % 1000000007;
                long l = fib * ((fib1 + fib2) % 1000000007);
                dp.put(n, l);
                return l;
            } else {
                long fib = fib((n - 1) / 2) % 1000000007;
                long fib1 = fib(((n - 1) / 2) + 1) % 1000000007;
                long l = ((fib * fib) % 1000000007) + ((fib1 * fib1) % 1000000007);
                dp.put(n, l);
                return l;
            }
        }
    }

}
