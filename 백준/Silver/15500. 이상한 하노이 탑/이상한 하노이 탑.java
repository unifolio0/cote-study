import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> f = new ArrayList<>();
        List<Integer> s = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            f.add(Integer.parseInt(st.nextToken()));
        }
        int count = 0;
        List<int[]> tmp = new ArrayList<>();
        while (true) {
            boolean ff = false;
            if (f.isEmpty() && s.isEmpty()) break;
            for (int i = f.size() - 1; i >= 0; i--) {
                if (f.get(i) == N) {
                    ff = true;
                    N--;
                    for (int j = f.size() - 1; j > i; j--) {
                        count++;
                        tmp.add(new int[] {1, 2});
                        s.add(f.get(j));
                        int r = f.remove(j);
                    }
                    int rr = f.remove(i);
                    count++;
                    tmp.add(new int[] {1, 3});
                    break;
                }
            }
            if (ff) continue;
            for (int i = s.size() - 1; i >= 0; i--) {
                if (s.get(i) == N) {
                    N--;
                    for (int j = s.size() - 1; j > i; j--) {
                        count++;
                        tmp.add(new int[] {2, 1});
                        f.add(s.get(j));
                        int r = s.remove(j);
                    }
                    int rr = s.remove(i);
                    count++;
                    tmp.add(new int[] {2, 3});
                    break;
                }
            }
        }
        bw.write(count + "\n");
        for (int i = 0; i < tmp.size(); i++) {
            bw.write(tmp.get(i)[0] + " " + tmp.get(i)[1] + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
