import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Long> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        if (N >= 1023) {
            bw.write(String.valueOf(-1));
        } else {
            for (int i = 0; i < 10; i++) {
                backtracking(String.valueOf(i), i);
            }
            List<Long> integers = nums.stream().sorted().collect(Collectors.toList());
            bw.write(String.valueOf(integers.get(N)));
        }

        br.close();

        bw.flush();
        bw.close();
    }

    private static void backtracking(String sNum, int d) {
        nums.add(Long.parseLong(sNum));
        for (int i = d + 1; i < 10; i++) {
            backtracking(String.valueOf(i) + sNum, i);
        }
    }
}
