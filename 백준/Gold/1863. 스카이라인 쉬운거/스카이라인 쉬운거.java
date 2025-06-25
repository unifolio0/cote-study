import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (list.isEmpty()) {
                list.add(y);
            } else {
                while (true) {
                    if (!list.isEmpty() && list.get(list.size() - 1) > y) {
                        list.remove(list.size() - 1);
                        count++;
                    } else {
                        break;
                    }
                }
                while (true) {
                    if (!list.isEmpty() && list.get(list.size() - 1) == y) {
                        list.remove(list.size() - 1);
                    } else {
                        break;
                    }
                }
                list.add(y);
            }
        }
        count += list.size();
        if (list.get(0) == 0) count--;
        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }
}
