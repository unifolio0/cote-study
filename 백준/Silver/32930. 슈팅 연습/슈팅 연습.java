import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        int x = 0;
        int y = 0;
        int tmp = 0;
        for (int i = 0; i < M; i++) {
            int finalX = x;
            int finalY = y;
            Collections.sort(list, (l1, l2) -> cal(l1[0], l1[1], finalX, finalY) - cal(l2[0], l2[1], finalX, finalY));
            tmp += cal(list.get(list.size() - 1)[0], list.get(list.size() - 1)[1], x, y);
            x = list.get(list.size() - 1)[0];
            y = list.get(list.size() - 1)[1];
            list.remove(list.size() - 1);
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }

        bw.write(String.valueOf(tmp));

        bw.flush();

        bw.close();
        br.close();
    }

    private static int cal(int x1, int y1, int x2, int y2) {
        return ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
    }
}
