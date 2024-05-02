import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> stack = new ArrayList<>();
        List<Integer> collect = Arrays.stream(br.readLine().split("")).map(Integer::parseInt)
                .collect(Collectors.toList());

        stack.add(collect.get(0));
        int i = 1;
        while (i != N) {
            while (K > 0 && !stack.isEmpty() && stack.get(stack.size() - 1) < collect.get(i)) {
                stack.remove(stack.size() - 1);
                K--;
            }

            stack.add(collect.get(i));
            i++;
        }

        while (K > 0) {
            stack.remove(stack.size() - 1);
            K--;
        }

        for (Integer integer : stack) {
            bw.write(String.valueOf(integer));
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
