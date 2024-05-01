import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int[] h = new int[N];
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }

        stack.add(h[0]);
        long c = 0;
        for (int i = 1; i < N; i++) {
            while(!stack.isEmpty() && stack.get(stack.size() - 1) <= h[i]) {
                stack.remove(stack.size() - 1);
            }
            c += stack.size();
            stack.add(h[i]);
        }

        bw.write(String.valueOf(c));

        br.close();

        bw.flush();
        bw.close();
    }
}
