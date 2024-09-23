import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, int[][]> bangsongs = new HashMap<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            String start = st.nextToken();
            String end = st.nextToken();

            String[] sta = start.split(":");
            String[] en = end.split(":");
            if (bangsongs.containsKey(name)) {
                int[][] ints = bangsongs.get(name);
                int time = (Integer.parseInt(en[0]) * 60 + Integer.parseInt(en[1])) - (Integer.parseInt(sta[0]) * 60 + Integer.parseInt(sta[1]));
                ints[day % 7 == 0 ? day / 7 - 1 : day / 7][day % 7] = time;
            } else {
                names.add(name);
                int[][] ints = new int[M / 7][7];
                int time = (Integer.parseInt(en[0]) * 60 + Integer.parseInt(en[1])) - (Integer.parseInt(sta[0]) * 60 + Integer.parseInt(sta[1]));
                ints[day % 7 == 0 ? day / 7 - 1 : day / 7][day % 7] = time;
                bangsongs.put(name, ints);
            }
        }
        List<String> vir = new ArrayList<>();
        for (String name : names) {
            boolean v = false;
            int[][] ints = bangsongs.get(name);
            for (int i = 0; i < M / 7; i++) {
                int count = 0;
                int t = 0;
                for (int j = 0; j < 7; j++) {
                    if (ints[i][j] == 0) continue;
                    count++;
                    t += ints[i][j];
                }
                if (count < 5 || t < 3600) {
                    v = true;
                    break;
                }
            }
            if (!v) {
                vir.add(name);
            }
        }
        if (vir.isEmpty()) {
            bw.write("-1");
        } else {
            List<String> strings = vir.stream().sorted().collect(Collectors.toList());
            for (String s : strings) {
                bw.write(s + "\n");
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}

