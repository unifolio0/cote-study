import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }
        List<int[]> list = Arrays.stream(line).sorted((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1])
                .collect(Collectors.toList());

        int min = list.get(0)[0], max = list.get(0)[1];
        int l = max - min;
        for (int[] ints : list) {
            if (max >= ints[1]) {
                continue;
            } else if (max >= ints[0]) {
                l += ints[1] - max;
            } else if (max < ints[0]) {
                l += ints[1] - ints[0];
            }
            min = ints[0];
            max = ints[1];
        }

        bw.write(String.valueOf(l));

        br.close();

        bw.flush();
        bw.close();
    }
}
