import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] Ns = new int[N];
        for (int i = 0; i < N; i++) {
            Ns[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] Ms = new int[M];
        for (int i = 0; i < M; i++) {
            Ms[i] = Integer.parseInt(st.nextToken());
        }

        int[] copy = Arrays.copyOfRange(Ns, 0, M);
        List<Integer> copys = Arrays.stream(copy).boxed().collect(Collectors.toList());
        int count = 0;
        for (int c : Ms) {
            if (copys.contains(c)) {
                count++;
            }
        }

        bw.write(String.valueOf(M - count));

        br.close();

        bw.flush();
        bw.close();
    }
}
