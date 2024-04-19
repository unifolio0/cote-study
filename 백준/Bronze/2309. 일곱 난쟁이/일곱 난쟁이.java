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

        int[] h = new int[9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h[i] = Integer.parseInt(st.nextToken());
        }

        int total = Arrays.stream(h).sum();
        int m = total - 100;
        boolean k = false;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (h[i] + h[j] == m) {
                    k = true;
                    int l = 0;
                    while (res.size() < 7) {
                        if (l == i || l == j) {
                            l++;
                            continue;
                        }
                        res.add(h[l++]);
                    }
                    break;
                }
            }
            if (k) {
                break;
            }
        }
        res = res.stream().sorted().collect(Collectors.toList());
        for (int i : res) {
            bw.write(String.valueOf(i) + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
